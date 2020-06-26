
CREATE TABLE public.usuario (
	id numeric(18,1) NOT NULL,
	email varchar(255) NULL,
	"role" numeric(1) NULL,
	senha varchar(255) NULL,
	nome varchar(255) NULL
);

CREATE TABLE public.produto (
	id int8 NOT NULL,
	descricao varchar(255) NULL,
	valor numeric(19,2) NULL,
	igredientes varchar(255) NULL,
	ativo bool NOT NULL DEFAULT true,
	CONSTRAINT produto_pkey PRIMARY KEY (id)
);

CREATE TABLE public.pedido (
	id numeric(18,1) NOT NULL,
	status numeric(9) NULL,
	endereco varchar(255) NULL,
	idcliente numeric(18,1) NULL,
	valortotal numeric(18,2) NULL
);

CREATE TABLE public.detalhepedido (
	id numeric(18,1) NOT NULL,
	idpedido numeric(18,1) NULL,
	idproduto numeric(18,1) NULL,
	quantidade numeric(18,1) NULL,
	valor numeric(18,2) NULL
);

CREATE SEQUENCE public.gen_detalhepedido
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;


-- public.gen_pedido definition

-- DROP SEQUENCE public.gen_pedido;

CREATE SEQUENCE public.gen_pedido
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;


-- public.gen_produto definition

-- DROP SEQUENCE public.gen_produto;

CREATE SEQUENCE public.gen_produto
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;


-- public.gen_usuario definition

-- DROP SEQUENCE public.gen_usuario;

CREATE SEQUENCE public.gen_usuario
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

INSERT INTO public.usuario (id, email, "role", senha, nome) VALUES(1.0, 'admin@admin', 1, '1234', 'admin');

SELECT setval('gen_usuario', 1);