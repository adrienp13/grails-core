package org.grails.cli

import spock.lang.Specification

class YamlCommandHandlerSpec extends Specification {
    YamlCommandHandler commandHandler
    
    def setup() {
        def profile = new SimpleProfile('web', new File('src/test/resources/profiles-repository/profiles/web'))
        commandHandler = profile.commandLineHandlers.find { it }
    }
    
    def "should have commands"() {
        expect:
        commandHandler.listCommands().size() == 4
    }
    
    def "commands should have descriptions"() {
        expect:
        commandHandler.listCommands().every { CommandDescription description ->
            description.description
        }
    }
    
    def "commands should have usage instructions"() {
        expect:
        commandHandler.listCommands().every { CommandDescription description ->
            description.usage
        }
    }
    
    

}