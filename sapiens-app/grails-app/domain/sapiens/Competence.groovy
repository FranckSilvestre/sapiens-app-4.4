package sapiens

class Competence {

	String code
	String libelleCourt
	String libelleLong

	DomaineCompetences domaine

	static belongsTo = [
		domaine:DomaineCompetences
	]

	String toString() {
		"$code - ${libelleCourt}"
	}
	
	static constraints = {
		code(blank:false)
		libelleCourt(blank:false)
		libelleLong(nullable:true)
	}
		
}
