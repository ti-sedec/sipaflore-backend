package br.com.sedec.sipaflore.config.report;

import br.com.sedec.sipaflore.config.exception.BadRequestException;

import java.util.List;
import java.util.Map;

public interface IReportService {

    ReportData getReportData(final String reportName, final Map<String, Object> parameters,
                             final ReportType format, final List<Object> items) throws BadRequestException;

}
