DROP TABLE IF EXISTS prod_cat;
DROP TABLE IF EXISTS produto;
DROP TABLE IF EXISTS categoria;

CREATE TABLE produto (
  Id Long(11) NOT NULL AUTO_INCREMENT,
  id_categoria int(11) NOT NULL,
  descricao varchar(255) NOT NULL,
  PRIMARY KEY (Id)
);

CREATE TABLE categoria (
  Id Long(11) NOT NULL AUTO_INCREMENT,
  categoria varchar(255) NOT NULL,
  PRIMARY KEY (Id)
);

CREATE TABLE prod_cat (
    produto_id BIGINT NOT NULL,
    categoria_id BIGINT NOT NULL,
    PRIMARY KEY (produto_id, categoria_id),
    CONSTRAINT FK_PRODUTO FOREIGN KEY (produto_id) REFERENCES PRODUTO (Id),
    CONSTRAINT FK_CATEGORIA FOREIGN KEY (categoria_id) REFERENCES CATEGORIA (Id)
);

INSERT INTO categoria (categoria) VALUES 
  ('Computers'),
  ('Electronics'),
  ('Fashion'),
  ('games'),
  ('Books');

INSERT INTO produto (id_categoria, descricao) VALUES 
  ('1','PC GAMER'),
  ('3','MAQUIAGEM AVON'),
  ('5','NARNIA'),
  ('2','SOM STEREO'),
  ('1','NOTEBOOK ACER'),
  ('4','GOD OF WAR');