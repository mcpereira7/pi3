SET FOREIGN_KEY_CHECKS=0;



DROP TABLE IF EXISTS Contato CASCADE
;
DROP TABLE IF EXISTS ContatoPessoa CASCADE
;
DROP TABLE IF EXISTS Endereco CASCADE
;
DROP TABLE IF EXISTS EnderecoPessoa CASCADE
;
DROP TABLE IF EXISTS EstoqueProduto CASCADE
;
DROP TABLE IF EXISTS Funcionarios CASCADE
;
DROP TABLE IF EXISTS GrupoPermissao CASCADE
;
DROP TABLE IF EXISTS GrupoPermissaoTelas CASCADE
;
DROP TABLE IF EXISTS ItensVenda CASCADE
;
DROP TABLE IF EXISTS MovimentoEstoque CASCADE
;
DROP TABLE IF EXISTS Pessoa CASCADE
;
DROP TABLE IF EXISTS PessoaFisica CASCADE
;
DROP TABLE IF EXISTS PessoaJuridica CASCADE
;
DROP TABLE IF EXISTS Produto CASCADE
;
DROP TABLE IF EXISTS Telas CASCADE
;
DROP TABLE IF EXISTS Tipo CASCADE
;
DROP TABLE IF EXISTS Usuarios CASCADE
;
DROP TABLE IF EXISTS Vendas CASCADE
;

CREATE TABLE Contato
(
	id_Contato INTEGER NOT NULL AUTO_INCREMENT,
	cod_objeto VARCHAR(40) NOT NULL,
	Tipo INTEGER NOT NULL,
	Valor VARCHAR(50) NOT NULL,
	PRIMARY KEY (id_Contato),
	UNIQUE UQ_Contato_cod_objeto(cod_objeto)

) 
;


CREATE TABLE ContatoPessoa
(
	cod_ObjetoPessoa VARCHAR(40) NOT NULL,
	cod_ObjetoContato VARCHAR(40) NOT NULL

) 
;


CREATE TABLE Endereco
(
	id_Endereco INTEGER NOT NULL AUTO_INCREMENT,
	id_Pessoa INTEGER NOT NULL,
	CEP VARCHAR(10) NOT NULL,
	Log VARCHAR(150) NOT NULL,
	Numero VARCHAR(20),
	Complemento VARCHAR(50),
	Bairro VARCHAR(100) NOT NULL,
	Cidade VARCHAR(100) NOT NULL,
	UF CHAR(2) NOT NULL,
	PRIMARY KEY (id_Endereco),
	UNIQUE UQ_Endereco_cod_objeto(id_Pessoa),
	KEY (id_Pessoa)

) 
;


CREATE TABLE EnderecoPessoa
(
	id INTEGER NOT NULL,
	cod_ObjetoEndereco VARCHAR(40) NOT NULL,
	cod_ObjetoPessoa VARCHAR(40) NOT NULL,
	Numero VARCHAR(20),
	Complemento VARCHAR(50),
	PRIMARY KEY (id)

) 
;


CREATE TABLE EstoqueProduto
(
	id_Produto INTEGER NOT NULL,
	Quantidade INTEGER NOT NULL DEFAULT 0,
	UNIQUE UQ_EstoqueProduto_id_Produto(id_Produto)

) 
;


CREATE TABLE Funcionarios
(
	id_Pessoa INTEGER NOT NULL,
	Codigo INTEGER NOT NULL DEFAULT 1,
	Funcao VARCHAR(50) NOT NULL,
	Salario FLOAT(0),
	UNIQUE UQ_Funcionarios_Codigo(Codigo),
	UNIQUE UQ_Funcionarios_id_Pessoa(id_Pessoa),
	KEY (id_Pessoa)

) 
;


CREATE TABLE GrupoPermissao
(
	id_Grupo INTEGER NOT NULL AUTO_INCREMENT,
	Nome VARCHAR(50) NOT NULL,
	PRIMARY KEY (id_Grupo)

) 
;


CREATE TABLE GrupoPermissaoTelas
(
	id_Grupo INTEGER NOT NULL,
	id_Tela INTEGER NOT NULL,
	KEY (id_Grupo),
	KEY (id_Tela)

) 
;


CREATE TABLE ItensVenda
(
	id_Venda INTEGER NOT NULL,
	id_Produto INTEGER NOT NULL,
	Quantidade INTEGER NOT NULL,
	Valor DOUBLE NOT NULL,
	PRIMARY KEY (id_Venda, id_Produto),
	KEY (id_Produto),
	KEY (id_Venda)

) 
;


CREATE TABLE MovimentoEstoque
(
	id_Movimento INTEGER NOT NULL AUTO_INCREMENT,
	id_produto INTEGER NOT NULL,
	Data DATETIME NOT NULL,
	Quantidade INTEGER NOT NULL,
	cod_ObjetoPessoa VARCHAR(40) NOT NULL,
	Tipo INTEGER NOT NULL,
	Natureza INTEGER NOT NULL,
	PRIMARY KEY (id_Movimento),
	UNIQUE UQ_MovimentoEstoque_id_produto(id_produto)

) 
;


CREATE TABLE Pessoa
(
	id_Pessoa INTEGER NOT NULL AUTO_INCREMENT,
	cod_objeto VARCHAR(40) NOT NULL,
	Nome VARCHAR(100) NOT NULL,
	Apelido VARCHAR(100),
	TipoPessoa INTEGER NOT NULL,
	dt_Cadastro DATE,
	Disable BIT,
	PRIMARY KEY (id_Pessoa),
	UNIQUE UQ_Pessoa_cod_objeto(cod_objeto),
	UNIQUE UQ_Pessoa_id_Pessoa(id_Pessoa)

) 
;


CREATE TABLE PessoaFisica
(
	id_PessoaFisica INTEGER NOT NULL AUTO_INCREMENT,
	id_Pessoa INTEGER NOT NULL,
	CPF VARCHAR(11) NOT NULL,
	dt_Nasc DATE,
	Sexo INTEGER,
	Email VARCHAR(150),
	Telefone VARCHAR(20),
	Telefone2 VARCHAR(20),
	PRIMARY KEY (id_PessoaFisica),
	UNIQUE UQ_PessoaFisica_id_Pessoa(id_Pessoa)

) 
;


CREATE TABLE PessoaJuridica
(
	id_Pessoa INTEGER NOT NULL AUTO_INCREMENT,
	CNPJ VARCHAR(14) NOT NULL,
	IE VARCHAR(12),
	ehCliente BIT NOT NULL,
	ehEmpresa BIT NOT NULL,
	Responsavel VARCHAR(100),
	Email VARCHAR(150),
	Telefone VARCHAR(20),
	Telefone2 VARCHAR(20),
	PRIMARY KEY (id_Pessoa)

) 
;


CREATE TABLE Produto
(
	id_produto INTEGER NOT NULL DEFAULT 1,
	Codigo INTEGER NOT NULL,
	Nome VARCHAR(100) NOT NULL,
	Descricao VARCHAR(200),
	Tipo INTEGER NOT NULL,
	dt_Cadastro DATE,
	Disable BIT,
	PRIMARY KEY (id_produto),
	UNIQUE UQ_Produto_Codigo(Codigo)

) 
;


CREATE TABLE Telas
(
	id_Tela INTEGER NOT NULL AUTO_INCREMENT,
	Nome VARCHAR(50) NOT NULL,
	PRIMARY KEY (id_Tela)

) 
;


CREATE TABLE Tipo
(
	id_Tipo INTEGER NOT NULL AUTO_INCREMENT,
	Codigo INTEGER NOT NULL,
	Descricao VARCHAR(50) NOT NULL,
	Categoria VARCHAR(50),
	PRIMARY KEY (id_Tipo)

) 
;


CREATE TABLE Usuarios
(
	id_Usuario INTEGER NOT NULL AUTO_INCREMENT,
	Nome VARCHAR(100) NOT NULL,
	Login VARCHAR(20) NOT NULL,
	Senha VARCHAR(20) NOT NULL,
	id_Grupo INTEGER NOT NULL,
	cod_objeto VARCHAR(40) NOT NULL,
	PRIMARY KEY (id_Usuario),
	UNIQUE UQ_Usuarios_cod_objeto(cod_objeto),
	UNIQUE UQ_Usuarios_id_Grupo(id_Grupo)

) 
;


CREATE TABLE Vendas
(
	id_Venda INTEGER NOT NULL AUTO_INCREMENT,
	Codigo INTEGER NOT NULL,
	id_Cliente INTEGER,
	ValorTotal DOUBLE NOT NULL,
	Data DATE NOT NULL,
	id_Vendedor INTEGER NOT NULL,
	PRIMARY KEY (id_Venda),
	UNIQUE UQ_Vendas_Codigo(Codigo),
	KEY (id_Vendedor)

) 
;



SET FOREIGN_KEY_CHECKS=1;


ALTER TABLE Endereco ADD CONSTRAINT FK_Endereco_Pessoa 
	FOREIGN KEY (id_Pessoa) REFERENCES Pessoa (id_Pessoa)
;

ALTER TABLE GrupoPermissao ADD CONSTRAINT FK_GrupoPermissao_Usuarios 
	FOREIGN KEY (id_Grupo) REFERENCES Usuarios (id_Grupo)
;

ALTER TABLE GrupoPermissaoTelas ADD CONSTRAINT FK_GrupoPermissaoTelas_GrupoPermissao 
	FOREIGN KEY (id_Grupo) REFERENCES GrupoPermissao (id_Grupo)
	ON DELETE CASCADE
;

ALTER TABLE GrupoPermissaoTelas ADD CONSTRAINT FK_GrupoPermissaoTelas_Telas 
	FOREIGN KEY (id_Tela) REFERENCES Telas (id_Tela)
	ON DELETE CASCADE
;

ALTER TABLE ItensVenda ADD CONSTRAINT FK_ItensVenda_Produto 
	FOREIGN KEY (id_Produto) REFERENCES Produto (id_produto)
	ON DELETE CASCADE
;

ALTER TABLE ItensVenda ADD CONSTRAINT FK_ItensVenda_Vendas 
	FOREIGN KEY (id_Venda) REFERENCES Vendas (id_Venda)
	ON DELETE CASCADE
;

ALTER TABLE PessoaJuridica ADD CONSTRAINT FK_Pessoajuridica_Pessoa 
	FOREIGN KEY (id_Pessoa) REFERENCES Pessoa (id_Pessoa)
;

ALTER TABLE Produto ADD CONSTRAINT FK_Produto_EstoqueProduto 
	FOREIGN KEY (id_produto) REFERENCES EstoqueProduto (id_Produto)
;

ALTER TABLE Vendas ADD CONSTRAINT FK_Vendas_Usuarios 
	FOREIGN KEY (id_Vendedor) REFERENCES Usuarios (id_Usuario)
;
