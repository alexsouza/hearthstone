insert into carta(id, nome, descricao, ataque, defesa, tipo, classe) values(nextval('hibernate_sequence'), 'Carta Teste', 'Carta teste descricao', 8, 5, 'MAGIA', 'MAGO');
insert into carta(id, nome, descricao, ataque, defesa, tipo, classe) values(nextval('hibernate_sequence'), 'Carta Teste 2','Carta teste descricao 2', 9, 4, 'CRIATURA', 'QUALQUER');
insert into baralho(id, nome,classe) values(nextval('hibernate_sequence'), 'Baralho teste', 'MAGO');