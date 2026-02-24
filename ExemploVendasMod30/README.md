
<!-- 
MEU BANCO DE DADOS PARA A AJUDA DO TUTOR -->











<!-- DROP TABLE IF EXISTS tb_produto_quantidade CASCADE;
DROP TABLE IF EXISTS tb_venda CASCADE;
DROP TABLE IF EXISTS tb_produto CASCADE;
DROP TABLE IF EXISTS tb_cliente CASCADE;







CREATE TABLE tb_cliente (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    telefone BIGINT,
    endereco VARCHAR(200),
    numero INTEGER,
    cidade VARCHAR(100),
    estado VARCHAR(50)
);

CREATE TABLE tb_produto (
    id BIGSERIAL PRIMARY KEY,
    codigo VARCHAR(20) UNIQUE NOT NULL,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),
    valor NUMERIC(10,2) NOT NULL
);

CREATE TABLE tb_venda (
    id BIGSERIAL PRIMARY KEY,
    codigo VARCHAR(20) UNIQUE NOT NULL,
    id_cliente BIGINT NOT NULL,
    valor_total NUMERIC(10,2),
    status VARCHAR(20),
    data_venda TIMESTAMP,
    FOREIGN KEY (id_cliente) REFERENCES tb_cliente(id)
);

CREATE TABLE tb_produto_quantidade (
    id BIGSERIAL PRIMARY KEY,
    id_venda BIGINT NOT NULL,
    id_produto BIGINT NOT NULL,
    quantidade INTEGER NOT NULL,
    valor_total NUMERIC(10,2),
    FOREIGN KEY (id_venda) REFERENCES tb_venda(id),
    FOREIGN KEY (id_produto) REFERENCES tb_produto(id)
); -->