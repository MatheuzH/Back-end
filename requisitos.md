# Requisitos para o Projeto Back-End
Criação do Banco de Dados e Código Back-End para um sistema ERP voltado para chamados.
|**Requisito**|**Descrição**  |
|--|--|
|R1|O sistema deve permitir a criação, leitura, atualização e deleção de chamados.|
|R2|Os chamados devem ter estados, sendo eles: aberto, fechado, pausado e pendente.|
|R3|Os chamados devem ser dividos em setores, sendo eles: TI, Operações e Comercial.|
|R4|Os chamados devem ter níveis de urgência, sendo eles: Muito Urgente, Urgente, Moderado, Não Urgente.|
|R5|Cada chamado deve ter um (1) responsável.|
|R6|Os chamados devem passar por um processo de triagem.|
|R7|O sistema deve permitir o cadástro de usuários.|
|R8|Os usuários devem ser divididos em: Cliente e Funcionário.|
|R9|Cliente só pode criar chamados e acompanhar seu estado.|
|R10|Funcionários devem ter cargos, sendo eles: Gestor Comercial, Gestor Operações, Analista Comercial, Analista de Operações, Analista de TI, Administrador do Sistema.|
|R11|Cada cargo só pode ver um tipo específico de setor de chamado.|
|R11.1|Gestor Comercial e Analista Comercial vê chamados do setor Comercial.|
|R11.2|Gestor de Operações e Analista de Operações vê chamados do setor de Operações.|
|R11.3|Analista de TI vê chamados do setor de TI.|
|R12|Administrador do Sistema pode ver tudo.|
|R13|Qualquer funcionário pode ver quem abriu o chamado.|
|R14|O analista de TI é responsável por definir a urgência de um chamado.|