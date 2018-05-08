Story: The Berlin Clock

Meta:
@scope interview

Narrative:
    As a clock enthusiast
    I want to tell the time using the Berlin Clock
    So that I can increase then number of ways that I can read the time

Scenario: Midnight
When the time is 00:00:00
Then the clock should look like
Y
0000
0000
00000000000
0000

Scenario: Middle of the afternoon
When the time is 13:17:01
Then the clock should look like
0
RR00
RRR0
YYR00000000
YY00

Scenario: Just before midnight
When the time is 23:59:59
Then the clock should look like
0
RRRR
RRR0
YYRYYRYYRYY
YYYY

Scenario: Midnight
When the time is 24:00:00
Then the clock should look like
Y
RRRR
RRRR
00000000000
0000



