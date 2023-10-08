Feature: Jira Issue Management

Background:
Given Set the endpoint
Given User Authentication

Scenario: Create Issue in Jira

When Create Issue
Then Validate Status Code 201

Scenario: Get Issue by Id in Jira

When Retrieve the request
Then Validate Status Code 200

Scenario Outline: Update Issue in Jira

When Update the request <Update_Json>
Then Validate Status Code 204

Examples:
|Update_Json|
|UpdateIssue.json|
|UpdateIssue2.json|
