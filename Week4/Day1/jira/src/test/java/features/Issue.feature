Feature: Jira Issue Management

Background:
Given Set the endpoint
Given User Authentication

Scenario: Create Issue in Jira

When Create Issue
Then Validate Status Code 201

Scenario: Get Issue by Id in Jira

When Retrieve the request
Then Validate Status Code 201

Scenario: Update Issue in Jira

When Update the request
Then Validate Status Code 204

