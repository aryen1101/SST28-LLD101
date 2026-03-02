In a real support system, once a ticket is created, it should be a permanent record. The old code was risky for these reasons:

Because there were setters, anyone could change a ticket’s details at any time. This is bad for audits because you lose the original record of what happened.
We made every field final and deleted all setters.
Once a ticket is made, it can never be changed. It is like writing in ink instead of pencil. If you need to "update" it, you must create a brand-new ticket.

The tags list was a direct reference. If you gave the list to someone else, they could add or remove tags without the IncidentTicket class even knowing
We protected the tags list so it can't be changed from the outside.
In the constructor, we create a copy of the list and wrap it in a Read-Only shell (unmodifiableList). If someone tries to add a tag to a finished ticket, the program will simply crash with an error to protect the data

Validation  was scattered in different files. It was very easy to accidentally create a broken ticket with a missing title or a wrong email address
The Builder collects all the info first. Only when you call .build() does it check all the rules (like is the email valid? or is the ID too long?). If everything is perfect, it creates the ticket.

If two different parts of the program were using the same ticket, one part could change the priority, and the other part would be surprised by the change
The toBuilder() method takes an existing ticket and puts all its data back into a Builder. You change one thing (like the assignee) and hit build() to get a fresh, updated ticket