Feature: Incident Management

Background: 
Given Set the endpoint
And Set the Auth

Scenario: Create Incident

When Create Incident with String Body '{"short_description":"service","description":"servicing desktop"}'
Then Validate the status code 201

Scenario: Get All Incidents

When Get Incidents Request
Then Validate the status code 200

Scenario Outline: Create Incident with Multiple Files

When Create Incident with File '<filename>'
Then Validate the response code 201

Examples:
|filename|
|IncidentCreation1.json|
|IncidentCreation2.json|

Scenario Outline: Update Incident with Mutiple Files

When Update Incident with File '<file>'
Then Validate the response code 200

Examples:
|file|
|IncidentCreation1.json|
|IncidentCreation2.json|

Scenario: Delete Incident with Id

When Delete Incident
Then Validate the response code 200

 
