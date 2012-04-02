package sapiens

import org.springframework.dao.DataIntegrityViolationException

class DomaineCompetencesController {
	
	GestionCompetencesService gestionCompetencesService

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [domaineCompetencesInstanceList: DomaineCompetences.list(params), domaineCompetencesInstanceTotal: DomaineCompetences.count()]
    }

    def create() {
        [domaineCompetencesInstance: new DomaineCompetences(params)]
    }

    def save() {
        def domaineCompetencesInstance = new DomaineCompetences(params)
        if (!gestionCompetencesService.updateDomaineCompetence(domaineCompetencesInstance)) {
            render(view: "create", model: [domaineCompetencesInstance: domaineCompetencesInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'domaineCompetences.label', default: 'DomaineCompetences'), domaineCompetencesInstance.id])
        redirect(action: "show", id: domaineCompetencesInstance.id)
    }

    def show() {
        def domaineCompetencesInstance = DomaineCompetences.get(params.id)
        if (!domaineCompetencesInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'domaineCompetences.label', default: 'DomaineCompetences'), params.id])
            redirect(action: "list")
            return
        }

        [domaineCompetencesInstance: domaineCompetencesInstance]
    }

    def edit() {
        def domaineCompetencesInstance = DomaineCompetences.get(params.id)
        if (!domaineCompetencesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'domaineCompetences.label', default: 'DomaineCompetences'), params.id])
            redirect(action: "list")
            return
        }

        [domaineCompetencesInstance: domaineCompetencesInstance]
    }

    def update() {
        def domaineCompetencesInstance = DomaineCompetences.get(params.id)
        if (!domaineCompetencesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'domaineCompetences.label', default: 'DomaineCompetences'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (domaineCompetencesInstance.version > version) {
                domaineCompetencesInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'domaineCompetences.label', default: 'DomaineCompetences')] as Object[],
                          "Another user has updated this DomaineCompetences while you were editing")
                render(view: "edit", model: [domaineCompetencesInstance: domaineCompetencesInstance])
                return
            }
        }

        domaineCompetencesInstance.properties = params

        if (!gestionCompetencesService.updateDomaineCompetence(domaineCompetencesInstance)) {
            render(view: "edit", model: [domaineCompetencesInstance: domaineCompetencesInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'domaineCompetences.label', default: 'DomaineCompetences'), domaineCompetencesInstance.id])
        redirect(action: "show", id: domaineCompetencesInstance.id)
    }

    def delete() {
        def domaineCompetencesInstance = DomaineCompetences.get(params.id)
        if (!domaineCompetencesInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'domaineCompetences.label', default: 'DomaineCompetences'), params.id])
            redirect(action: "list")
            return
        }

        try {
			gestionCompetencesService.deleteDomaineCompetences(domaineCompetencesInstance)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'domaineCompetences.label', default: 'DomaineCompetences'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'domaineCompetences.label', default: 'DomaineCompetences'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
