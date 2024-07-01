package br.com.sedec.sipaflore.config.rsql;

public interface RsqlDoc {

    /**
     * *** Os números utilizados são fictícios e servem apenas como exemplo ***
     * Formas de pesquisar com RSQL:
     *
     * EQUAL -> field==2                                   |                 id == 2
     * EQUAL TO EMPTY STRING -> field==''                  |                 nome == ''
     * NOT EQUAL -> field!=2                               |                 id != 2
     * LIKE -> field==*demo*                               |                 nome LIKE *demo*
     * LIKE -> field==demo*                                |                 nome LIKE demo*
     * LIKE -> field==*demo                                |                 nome LIKE *demo
     * IN -> field=in=(2, 4)                               |                 id IN (2, 4)
     * OUT -> field=out=(2, 4)                             |                 id NOT IN (2, 4)
     *
     * GREATER THAN -> field=gt=100                        |                 id > 100
     * GREATER THAN -> field>100                           |                 id > 100
     * GREATER THAN OR EQUAL -> field=ge=100               |                 id >= 100
     * GREATER THAN OR EQUAL -> field>=100                 |                 id >= 100
     * LESS THAN -> field=lt=100                           |                 id < 100
     * LESS THAN -> field<100                              |                 id < 100
     * LESS THAN OR EQUAL -> field=le=100                  |                 id <= 100
     * LESS THAN OR EQUAL -> field<=100                    |                 id <= 100
     *
     * AND -> field1==2;field2==4                          |                 id == 2 && id == 4
     * AND -> field1==2 and field2==4                      |                 id == 2 && id == 4
     * OR -> field1==2,field2==4                           |                 id == 2 || id == 4
     * OR -> field1==2 or field2==4                        |                 id == 2 || id == 4
     *
     * IS NULL -> field==null                            |                   nome IS NULL
     * NOT NULL -> field!=null                          |                    nome IS NOT NULL
     */

}
