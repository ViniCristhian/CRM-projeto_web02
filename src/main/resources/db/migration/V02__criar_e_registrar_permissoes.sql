CREATE TABLE PERMISSOES (
    id INT PRIMARY KEY,
    descricao VARCHAR(50) NOT NULL
)

CREATE TABLE PERFIS_PERMISSOES (
    id_perfil INT NOT NULL,
    id_permissao INT NOT NULL,
    PRIMARY KEY (id_perfil, id_permissao),
    FOREIGN KEY (id_perfil) REFERENCES PERFIS(id_perfil),
    FOREIGN KEY (id_permissao) REFERENCES PERMISSOES(id)
)
GO