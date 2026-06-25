🎓 Gestor Universitário - Finanças Pessoais

📌 Sobre o Projeto

O Gestor Universitário é uma aplicação web completa (Full-Stack) desenvolvida para ajudar estudantes universitários a organizarem e gerirem as suas despesas académicas. O sistema permite registar gastos diários (como mensalidades, transporte, livros e alimentação) e oferece um painel de controlo visual com alertas para débitos pendentes e em atraso.

Este projeto foi construído utilizando os padrões de arquitetura RESTful no Back-end e uma interface reativa e modular no Front-end.

✨ Funcionalidades

Autenticação de Utilizadores: Sistema de registo e login para acesso seguro à plataforma.

Dashboard Financeiro: Visão geral com o total de utilizadores na plataforma, receitas pagas, pendentes e totais de registos, tudo calculado dinamicamente.

Gestão de Despesas (CRUD): Capacidade de criar, ler, atualizar e eliminar gastos, categorizados por:

Mensalidade

Livros e Materiais

Transporte

Alimentação/Lanche

Outros Gastos

Sistema de Alertas Visuais: Separação automática de despesas em atraso, a vencer e pagas, com cores intuitivas.

Regra de Negócio (Freemium): Implementação de uma restrição no Back-end que limita os utilizadores básicos a registarem no máximo 5 despesas (simulando um plano Freemium).

🛠️ Tecnologias Utilizadas

Back-end

Java 17

Spring Boot (Web, Data JPA, Validation)

MySQL (Base de dados relacional)

Maven (Gestor de dependências)

Front-end

HTML5 & CSS3

JavaScript (Vanilla)

Tailwind CSS (Estilização responsiva e rápida)

Lucide Icons (Ícones da interface)

🚀 Como Executar o Projeto Localmente

Pré-requisitos

Certifique-se de que tem instalado na sua máquina:

Java Development Kit (JDK) 17+

MySQL (ou XAMPP para gerir a base de dados local)

Opcional: Visual Studio Code ou outra IDE.

1. Configurar a Base de Dados

Inicie o seu servidor MySQL.

Crie uma base de dados (o Spring Boot pode criar as tabelas automaticamente se estiver configurado com ddl-auto=update).

CREATE DATABASE gestor_universitario;


2. Executar o Back-end (Spring Boot)

Clone este repositório:

git clone [https://github.com/SEU-USUARIO/gestor-universitario.git](https://github.com/SEU-USUARIO/gestor-universitario.git)


Navegue até à pasta do projeto:

cd gestor-universitario


Execute a aplicação utilizando o Maven:

./mvnw spring-boot:run


A API estará disponível em http://localhost:8080.

3. Executar o Front-end

Vá até à pasta frontend do projeto.

Abra o ficheiro index.html diretamente no seu navegador.

Crie uma conta no sistema e desfrute da aplicação!

📸 Capturas de Ecrã

Tela de Login
<img width="945" height="502" alt="image" src="https://github.com/user-attachments/assets/268d070f-9230-4396-828f-1668e10df89f" />
<img width="945" height="501" alt="image" src="https://github.com/user-attachments/assets/86eb19d5-9b14-498d-8b4e-962c8ce94925" />


Dashboard
<img width="945" height="501" alt="image" src="https://github.com/user-attachments/assets/e4d068c4-8c4d-44f0-a4d1-9dcf2555b8cb" />


Gestão de Despesas
<img width="945" height="500" alt="image" src="https://github.com/user-attachments/assets/533ef2fa-6e2b-4749-8769-7c359cd11ddb" />

👨‍💻 Autor
Luis Henrique Werner
