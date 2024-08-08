-- Adding Client to a Project.
-- We're assuming that each Project needs a Client
ALTER TABLE Project
ADD COLUMN ClientID int;
-- We're not assuming that a Project needs a Client

-- Adding separate constraint for it to reference Client ID.
ALTER TABLE Project
ADD CONSTRAINT FK_Client FOREIGN KEY (ClientID) REFERENCES Client(id);