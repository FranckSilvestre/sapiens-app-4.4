<html>
    <head>
        <title>Sapiens-app</title>
		<meta name="layout" content="main" />
    </head>
    <body>
        <h1 style="margin-left:20px;">Sapiens-app</h1>
        <p style="margin-left:20px;width:80%; margin-bottom: 10px;">Bienvenue sur l'application de gestion et de suivi de
        compétences sapiens-app</p>
        <div style="margin-left:40px;width:60%">
            <ul>
              <li><g:link controller="domaineCompetences">Gérer les domaines de compétences</g:link></li>
              <li><g:link controller="competence">Gérer les compétences</g:link></li>
              <li><g:link controller="acteur">Gérer les acteurs</g:link></li>
              <li><g:link controller="suiviCompetence">Suivre les compétences</g:link></li>
<%--              <li><g:link controller="suiviCompetence" action="moteurRecherche">Recherche des suivis de compétences</g:link></li>--%>
            </ul>
        </div>
    </body>
</html>