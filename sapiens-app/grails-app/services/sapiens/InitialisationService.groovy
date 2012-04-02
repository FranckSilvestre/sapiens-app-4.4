package sapiens

class InitialisationService {

	boolean transactional = true
	ActeurService acteurService
	GestionCompetencesService gestionCompetencesService
	
    def initialiseDonneesReferenciel() {
		def roleApprenant = new Role (
			code : RoleCode.APPRENANT.name(),
			libelleCourt:"Apprenant"
			)
		roleApprenant.save()

		def roleGestionnaire = new Role (
			code : RoleCode.GESTIONNAIRE.name(),
			libelleCourt:"Gestionnaire")
		roleGestionnaire.save()
    }
	
	def initialiseDonneesTest() {
		
			// domaines de comp�tence
			DomaineCompetences scf = gestionCompetencesService.newDomaineCompetences(
					"SOCLE_COMMUN_FRAN",
					"Socle commun de comp�tences en fran�ais"
			)
			
			DomaineCompetences scm = gestionCompetencesService.newDomaineCompetences(
					"SOCLE_COMMUN_MATH",
					"Socle commun de comp�tences en Math�matiques"
			)
		
			// comp�tences
			gestionCompetencesService.newCompetence(
					"SCF_001",
					"Savoir reconna�tre le temps des verbes",
					scf
			)
			gestionCompetencesService.newCompetence(
					"SCF_002",
					"Savoir reconna�tre les constructions grammaticales",
					scf
			)
			gestionCompetencesService.newCompetence(
					"SCF_003",
					"Savoir diff�rencier les adverbes des ajectifs",
					scf
			)
			gestionCompetencesService.newCompetence(
					"SCF_004",
					"Savoir conjuguer les verbes du premier groupe au subjonctif pr�sent",
					scf
			)
			gestionCompetencesService.newCompetence(
					"SCF_005",
					"Savoir conjuguer les verbes du deuxi�me groupe au subjonctif pr�sent",
					scf
			)
		
			gestionCompetencesService.newCompetence(
					"SCM_001",
					"Savoir utiliser les quatres op�rations de bases",
					scm
			)
			gestionCompetencesService.newCompetence(
					"SCM_002",
					"Savoir simplifier des fractions",
					scm
			)
			gestionCompetencesService.newCompetence(
					"SCM_003",
					"Savoir identifier les situations de proportionnalit�",
					scm
			)
			gestionCompetencesService.newCompetence(
					"SCM_004",
					"Savoir reconna�tre une identit� remarquable",
					scm
			)
			gestionCompetencesService.newCompetence(
					"SCF_005",
					"Savoir d�velopper et factoriser",
					 scm
			)
		
			// acteurs
			acteurService.newApprenant("Durand","C�cile")
			acteurService.newApprenant("Dupont","Jacques")
			acteurService.newApprenant("Grimal","Tom")
			acteurService.newApprenant("Cros","Caherine")
			acteurService.newApprenant("Douame","Bongo")
			acteurService.newApprenant("Alim","Aisha")
			acteurService.newApprenant("Nouvel","Pierre")
			acteurService.newApprenant("Mendi","Erica")
			acteurService.newApprenant("Bousquet","Patricia")
			acteurService.newApprenant("Caron","Bertrand")
		
		  }
}
