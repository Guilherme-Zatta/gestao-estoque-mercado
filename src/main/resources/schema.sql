drop table if exists movimentacoes;
drop table if exists produtos;
drop table if exists mercados;

CREATE TABLE produtos (
  ID SERIAL,
  DESCRICAO VARCHAR,
  MARCA VARCHAR,
  TIPO VARCHAR,
  SALDO DOUBLE PRECISION,
  PRIMARY KEY (ID)
);
 
insert into produtos (DESCRICAO, MARCA, TIPO, SALDO)
values ('CEBOLA', 'CANTU', 'HORTIFRUTI', 10);
 
CREATE TABLE mercados (
  ID SERIAL,
  NOME VARCHAR,
  ENDERECO VARCHAR,
  CIDADE VARCHAR,
  ESTADO VARCHAR,
  CNPJ VARCHAR,
  IE VARCHAR,
  PRIMARY KEY (ID)
);
 
insert into mercados (NOME, ENDERECO, CIDADE, ESTADO, CNPJ, IE)
values ('CENTER NORTE', 'RUA PROCÓPIO DE LIMA, 460', 'PATO BRANCO', 'PR', '40482821000126', '8849344197');
 
CREATE TABLE movimentacoes (
  ID SERIAL,
  MERCADO_ID INT,
  PRODUTO_ID INT,
  DATA_HORA TIMESTAMP,
  TIPO_MOVIMENTACAO char,
  QUANTIDADE DOUBLE PRECISION,
  PRIMARY KEY (ID),
  foreign key (mercado_id) references mercados (id),
  foreign key (produto_id) references produtos (id)
);
 

insert into movimentacoes (mercado_id, produto_id, data_hora, tipo_movimentacao, quantidade)
values (1, 1, '2024-07-08 21:20:37.008', 'E', 10);
 
