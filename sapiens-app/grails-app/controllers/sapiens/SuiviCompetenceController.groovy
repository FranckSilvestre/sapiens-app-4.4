package sapiens

class SuiviCompetenceController {

	def index = {
		[domaines: DomaineCompetences.list()]
	}

	def selectionne = {
		def domaines = DomaineCompetences.list()
		def domaineSelectionne = DomaineCompetences.get(params['domaine.id'])
		render(view: 'index',
				model:[
					domaines: domaines,
					domaineSelectionne: domaineSelectionne
				]
				)
	}

	def changeEtatSuiviCompetence = {
		def domaines = DomaineCompetences.list()
		def domaineSelectionne = DomaineCompetences.get(params['idDomaine'])
		def suiviCompetence = SuiviCompetence.get(params.id)
		switch (suiviCompetence.etat) {
			case SuiviCompetenceEtat.NON_ACQUIS.name() :
				suiviCompetence.etat = SuiviCompetenceEtat.EN_COURS_ACQUISITION
				break;
			case SuiviCompetenceEtat.EN_COURS_ACQUISITION.name() :
				suiviCompetence.etat = SuiviCompetenceEtat.ACQUIS
				break;
			case SuiviCompetenceEtat.ACQUIS.name() :
				suiviCompetence.etat = SuiviCompetenceEtat.NON_ACQUIS
				break;
		}
		suiviCompetence.save()
		render(view: 'index',
				model:[
					domaines: domaines,
					domaineSelectionne: domaineSelectionne
				]
				)
	}
}
