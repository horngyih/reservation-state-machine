# Java Enum as State Machine

The following code repository demonstrates how a Java Enum implementation can be used 
to model a State Machine.

The demo code uses the Reservation Status enumeration to emulate how a Java Enum class can also be used to model the states at which Reservation Status can progress as a State Machine.

Given that the states of a reservation can be:-

- UNKNOWN
- REQDENIED
- WAITLIST
- PAYPEND
- PAYFAIL
- CONFIRM
- REDEEM
- CANCELED
- REINSTATE
- NOSHOW
- CIWAITING
- INHOUSE
- COWAITING
- CHECKOUT

The following figure illustrates the path at which the State of a Room Reservation Status can prograss.

```mermaid
stateDiagram-v2
[*] --> WAITLIST 
[*]--> UNKNOWN 
[*] --> REQDENIED 
[*] --> PAYPEND 
[*] --> NOSHOW 
[*] --> INHOUSE 
[*] --> CONFIRM 
[*] --> CHECKOUT 
WAITLIST --> CONFIRM 
REINSTATE --> NOSHOW 
REINSTATE --> INHOUSE 
REINSTATE --> CONFIRM 
REINSTATE --> CIWAITING 
REINSTATE --> CANCELED 
REDEEM --> CONFIRM 
REDEEM --> CANCELED 
PAYPEND --> PAYFAIL 
PAYPEND --> CONFIRM 
PAYFAIL --> WAITLIST 
PAYFAIL --> PAYPEND 
INHOUSE --> COWAITING 
INHOUSE --> CHECKOUT 
COWAITING --> INHOUSE 
COWAITING --> CHECKOUT 
CONFIRM --> REDEEM 
CONFIRM --> NOSHOW 
CONFIRM --> INHOUSE 
CONFIRM --> CIWAITING 
CONFIRM --> CANCELED 
CIWAITING --> NOSHOW 
CIWAITING --> INHOUSE 
CIWAITING --> CONFIRM 
CANCELED --> REINSTATE 
CANCELED --> CONFIRM
```
