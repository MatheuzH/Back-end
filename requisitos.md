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
|R8|Todo usuário é um funcionário, e somente um Adminstrador pode cadastrar um usuário.|
|R9|Funcionários devem ter cargos, sendo eles: Gestor Comercial, Gestor Operações, Analista Comercial, Analista de Operações, Analista de TI, Administrador do Sistema.|
|R10|Cada cargo só pode ver um tipo específico de setor de chamado.|
|R10.1|Gestor Comercial e Analista Comercial vê chamados do setor Comercial.|
|R10.2|Gestor de Operações e Analista de Operações vê chamados do setor de Operações.|
|R10.3|Analista de TI vê chamados do setor de TI.|
|R10.4|Administrador do Sistema pode ver tudo.|
|R11|Qualquer funcionário pode ver quem abriu o chamado.|
|R12|O analista de TI é responsável por definir a urgência de um chamado.|
