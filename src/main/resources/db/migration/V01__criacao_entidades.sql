-- Tabela de Perfis de Acesso
CREATE TABLE PERFIS (
    id_perfil INT PRIMARY KEY IDENTITY(1,1),
    nome_perfil VARCHAR(50) UNIQUE NOT NULL,
    descricao VARCHAR(255)
);

-- Criação da Tabela de Usuários
CREATE TABLE USUARIOS (
    id_usuario INT PRIMARY KEY IDENTITY(1,1),
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(255) UNIQUE NOT NULL,
    id_perfil INT NOT NULL FOREIGN KEY (id_perfil) REFERENCES PERFIS(id_perfil),
    ativo BIT DEFAULT 1,
    data_criacao DATE NOT NULL DEFAULT GETDATE()
);

-- Criação da Tabela de Setores
CREATE TABLE SETORES (
    id_setor INT PRIMARY KEY IDENTITY(1,1),
    titulo VARCHAR(50) UNIQUE NOT NULL,
    descricao VARCHAR(255)
);

-- Criação da Tabela de Cargos
CREATE TABLE CARGOS (
    id_cargo INT PRIMARY KEY IDENTITY(1,1),
    titulo VARCHAR(50) UNIQUE NOT NULL,
    descricao VARCHAR(255)
);

-- Criação da Tabela de Tipos de Interação
CREATE TABLE TIPOS_INTERACAO (
    id_tipo_interacao INT PRIMARY KEY IDENTITY(1,1),
    tipo VARCHAR(50) UNIQUE NOT NULL,
    descricao VARCHAR(255)
);

-- Criação da Tabela de Estágios de Venda
CREATE TABLE ESTAGIOS_VENDA (
    id_estagio INT PRIMARY KEY IDENTITY(1,1),
    estagio VARCHAR(50) UNIQUE NOT NULL,
    descricao VARCHAR(255)
);

-- Criação da Tabela de Status de Tarefa
CREATE TABLE STATUS_TAFERA (
    id_status_tarefa INT PRIMARY KEY IDENTITY(1,1),
    status VARCHAR(50) UNIQUE NOT NULL,
    descricao VARCHAR(255)
);

-- Criação da Tabela de Contas
CREATE TABLE CONTAS (
    id_conta INT PRIMARY KEY IDENTITY(1, 1),
    nome_empresa VARCHAR(150) NOT NULL,
    cnpj VARCHAR(18) NOT NULL UNIQUE,
    data_cadastro DATETIME DEFAULT GETDATE(),
    id_setor INT NOT NULL FOREIGN KEY REFERENCES SETORES(id_setor)
);

-- Criação da Tabela de Contatos
CREATE TABLE CONTATOS (
    id_contato INT PRIMARY KEY IDENTITY(1,1),
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    id_cargo INT NOT NULL FOREIGN KEY REFERENCES CARGOS(id_cargo),
    id_conta INT NOT NULL FOREIGN KEY REFERENCES CONTAS(id_conta)
);

-- Criação da Tabela de Oportunidades
CREATE TABLE OPORTUNIDADES (
    id_oportunidade INT PRIMARY KEY IDENTITY(1,1),
    nome_negocio VARCHAR(100) NOT NULL,
    valor DECIMAL(12,2) NOT NULL,
    data_criacao DATE NOT NULL,
    data_fechamento DATE,
    id_estagio INT NOT NULL FOREIGN KEY REFERENCES ESTAGIOS_VENDA(id_estagio),
    id_conta INT NOT NULL FOREIGN KEY REFERENCES CONTAS(id_conta)
);

-- Criação da Tabela de Interações
CREATE TABLE INTERACOES (
    id_interacao INT PRIMARY KEY IDENTITY(1,1),
    data_interacao DATETIME NOT NULL,
    descricao TEXT NOT NULL,
    id_tipo_interacao INT NOT NULL FOREIGN KEY REFERENCES TIPOS_INTERACAO(id_tipo_interacao),
    id_contato INT NOT NULL FOREIGN KEY REFERENCES CONTATOS(id_contato)
);

-- Criação da Tabela de Tarefas
CREATE TABLE TAREFAS (
    id_tarefa INT PRIMARY KEY IDENTITY(1,1),
    titulo VARCHAR(100) NOT NULL,
    data_vencimento DATE NOT NULL,
    id_status_tarefa INT NOT NULL FOREIGN KEY REFERENCES STATUS_TAFERA(id_status_tarefa),
    id_oportunidade INT NOT NULL FOREIGN KEY REFERENCES OPORTUNIDADES(id_oportunidade)
);


GO