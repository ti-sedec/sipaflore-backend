package br.com.sedec.sipaflore.config.rsql;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class RsqlUtil {

    public static <T> Specification<T> parseRsql(final String search) {
        final Node rootNode = new RSQLParser().parse(search);
        return rootNode.accept(new RsqlVisitor<>());
    }

}
