<html>
<head>
<title>Sapiens-app</title>
<meta name="layout" content="main" />

</head>
<body>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
	<div id="list-competence" class="content scaffold-list" role="main">
		<h1>Suivi de compétences</h1>
		<g:if test="${flash.message}">
			<div class="message">
				${flash.message}
			</div>
		</g:if>
		<g:form method="post">
			<div class="dialog">
				<table>
					<tbody>

						<tr class="prop">
							<td valign="top" class="name"><label for="domaine">Domaine:</label>
							</td>
							<td valign="top" class="value"><g:select optionKey="id"
									from="${domaines}" name="domaine.id"
									value="${domaineSelectionne?.id}"></g:select>
									<span class="button"><g:actionSubmit value="Selectionner"
						action="selectionne" /></span>
									</td>
						</tr>

					</tbody>
				</table>
			</div>

		</g:form>

		<g:if test="${domaineSelectionne}">


			<div class="list" style="padding-top: 10px">
				<table>
					<thead>
						<tr>


							<g:sortableColumn property="acteur.nom" title="Nom" />

							<g:sortableColumn property="acteur.prenom" title="Prenom" />

							<g:each var="competence" in="${domaineSelectionne.competences}">
								<th title="${competence.libelleCourt}">
									${competence.code}
								</th>
							</g:each>

						</tr>
					</thead>
					<tbody>
						<g:each in="${domaineSelectionne.acteursEvaluesTries}" status="i"
							var="acteur">
							<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">


								<td>
									${fieldValue(bean: acteur, field: 'nom')}
								</td>

								<td>
									${fieldValue(bean: acteur, field: 'prenom')}
								</td>

								<g:each var="competence" in="${domaineSelectionne.competences}">
									<g:set var="suiviCompetence"  value="${sapiens.SuiviCompetence.findByActeurAndCompetence(acteur,competence)}"/>
									<td class="${suiviCompetence?.etat.toLowerCase()}"><g:link
											action="changeEtatSuiviCompetence" id="${suiviCompetence?.id}"
											params="[idDomaine:domaineSelectionne.id]" title="${suiviCompetence?.etat}">
											[change]
										</g:link></td>
								</g:each>

							</tr>
						</g:each>
					</tbody>
				</table>
			</div>
		</g:if>

	</div>
</body>
</html>