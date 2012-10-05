package org.grails.plugin.foursquare

import org.codehaus.groovy.grails.commons.ConfigurationHolder

class FoursquareService {

    static transactional = false

    @Delegate UserService userService
    @Delegate VenueService venueService
    @Delegate CheckinsService checkinsService

    String getResponseFromFourSquare(String urlPath) {
        String responseData
        try {
            URL url = new URL(urlPath)
            responseData = url.text
        } catch (Exception e) {
            e.printStackTrace()
        }
        return responseData
    }

    String getResponseOfFoursquareQuery(String urlString) {
        println("****** Querying URL: ${urlString}")
        String responseString = ''
        try {
            URL page = new URL(urlString);
            responseString = page.text
        } catch (Exception e) {
            e.printStackTrace()
        }
        return responseString
    }


    public getClientSecret() {
        return ConfigurationHolder.config.fourSquare.secret
    }

    public getClientId() {
        return ConfigurationHolder.config.fourSquare.clientId
    }
}
