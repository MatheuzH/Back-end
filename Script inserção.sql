INSERT INTO setor VALUES(1, "TI"), (2, "Comercial"), (3, "Operações");

INSERT INTO cargos VALUES(1, "Analista de TI", 1), (2, "Analista de Comercial", 2), (3, "Analista de Operações", 3);
insert into urgencia values(1, "muito urgente", "até 30min");
insert into chamadostatus(Status) values("aberto");
insert into chamadostatus(Status) values("pendente"),("pausado"),("fechado");
select * from funcionarios;
select * from cargos;
select * from setor;
select * from chamadostatus;
select * from chamados;
select * from urgencia;

INSERT INTO chamados(nomeChamado,descricao,responsavelChamado,fk_urgencia,inicioChamado,responsavelSolicitante,fk_setor,fk_chamadoStatus)
values("oi","preciso de ajuda para ligar o pc",1,1,"2023-05-31",2,1,1);