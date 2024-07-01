package br.com.sedec.sipaflore.config.report;

import br.com.sedec.sipaflore.config.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.Objects.isNull;
import static net.sf.jasperreports.engine.JasperExportManager.exportReportToPdf;
import static net.sf.jasperreports.engine.JasperFillManager.fillReport;

@Service
@RequiredArgsConstructor
public class ReportService implements IReportService {

    private static final String ERROR_REPORT = "error.report";
    private static final String PATTERN_NOME_ARQUIVO = "ddMMyyyy_HHmmss";

    public ReportData getReportData(final String reportName, final Map<String, Object> parameters,
                                    final ReportType format, final List<Object> items) throws BadRequestException {
        try {
            final LocalDateTime dateTime = now();
            final String filename =
                reportName.split("\\.")[0] + "_" + dateTime.format(ofPattern(PATTERN_NOME_ARQUIVO)) +
                    "." + format.getExtension();

            final File file = getFile(reportName);
            final JasperReport jasperReport = (JasperReport) JRLoader.loadObject(file);
            final JasperPrint jasperPrint = fillReport(jasperReport, parameters, new JRBeanCollectionDataSource(items));
            final byte[] reportContent = exportReportToPdf(jasperPrint);
            return new ReportData(reportContent, filename, format);
        } catch (final JRException | BadRequestException e) {
            throw new BadRequestException(ERROR_REPORT);
        }
    }

    private File getFile(final String reportName) throws BadRequestException {
        final URL resource = getClass().getResource("/templates/report/" + reportName + ".jasper");

        if (isNull(resource)) {
            throw new BadRequestException(ERROR_REPORT);
        }

        return new File(resource.getFile());
    }

}
