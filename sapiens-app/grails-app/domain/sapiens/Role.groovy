package sapiens

class Role {

	String code
	String libelleCourt
	String libelleLong

	static constraints = {
		code(blank:false, inList :(RoleCode.values())*.name() as List )
		libelleCourt(blank:false)
		libelleLong(nullable:true)
	}
	
	String toString() {
		libelleCourt
	}
	
}

enum RoleCode {
	APPRENANT,
	GESTIONNAIRE
}