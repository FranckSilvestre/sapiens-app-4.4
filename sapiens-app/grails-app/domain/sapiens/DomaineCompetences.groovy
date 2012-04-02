package sapiens

class DomaineCompetences {

	String code
	String libelleCourt
	String libelleLong

	static hasMany = [
		competences: Competence,
		acteursEvalues : Acteur
	]

	static constraints = {
		code(blank:false)
		libelleCourt(blank:false)
		libelleLong(nullable:true)
	}

	String toString() {
		libelleCourt
	}
	
	static mapping = {
		competences sort:'code'
	  }

	List<Acteur> getActeursEvaluesTries() {
		acteursEvalues.sort { it.nom }
	}
}
