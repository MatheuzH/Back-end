INSERT INTO setor VALUES(1, "TI"), (2, "Comercial"), (3, "Operações");

INSERT INTO cargos VALUES(1, "gestor comercial", 2), (2, "gestor operacoes", 3), (3, "analista comercial", 2),
(4, "analista de operacoes", 3), (5, "admin do sistema", null), (6, "analista de ti", 1);
insert into urgencia values(1, "muito urgente", "até 30min");
insert into chamadostatus(Status) values("aberto");
insert into chamadostatus(Status) values("pendente"),("pausado"),("fechado");
select * from funcionarios;
select * from cargos;
select * from setor;
select * from chamadostatus;
select * from chamados;
select * from urgencia;
