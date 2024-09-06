INSERT INTO capability (capabilityId, capabilityName) VALUES (1, 'Engineering');
INSERT INTO capability (capabilityId, capabilityName) VALUES (2, 'Platforms');
INSERT INTO capability (capabilityId, capabilityName) VALUES (3, 'Data and Artificial Intelligence');
INSERT INTO capability (capabilityId, capabilityName) VALUES (4, 'Cyber Security');
INSERT INTO capability (capabilityId, capabilityName) VALUES (5, 'Workday');
INSERT INTO capability (capabilityId, capabilityName) VALUES (6, 'Experience Design');
INSERT INTO capability (capabilityId, capabilityName) VALUES (7, 'Product');
INSERT INTO capability (capabilityId, capabilityName) VALUES (8, 'Delivery');
INSERT INTO capability (capabilityId, capabilityName) VALUES (9, 'Operations');
INSERT INTO capability (capabilityId, capabilityName) VALUES (10, 'Business Development and Marketing');
INSERT INTO capability (capabilityId, capabilityName) VALUES (11, 'Organisational Stragety and Planning');
INSERT INTO capability (capabilityId, capabilityName) VALUES (12, 'People');
INSERT INTO capability (capabilityId, capabilityName) VALUES (13, 'Commercial and Financial Management');
INSERT INTO capability (capabilityId, capabilityName) VALUES (14, 'Business Services Support');

INSERT INTO band (nameId, bandName) VALUES (1, 'Apprentice');
INSERT INTO band (nameId, bandName) VALUES (2, 'Trainee');
INSERT INTO band (nameId, bandName) VALUES (3, 'Associate');
INSERT INTO band (nameId, bandName) VALUES (4, 'Senior Associate');
INSERT INTO band (nameId, bandName) VALUES (5, 'Consultant');
INSERT INTO band (nameId, bandName) VALUES (6, 'Manager');
INSERT INTO band (nameId, bandName) VALUES (7, 'Principal');
INSERT INTO band (nameId, bandName) VALUES (8, 'Leadership Community');

INSERT INTO status (statusId, statusName) VALUES (1, 'Open');
INSERT INTO status (statusId, statusName) VALUES (2, 'Closed');

INSERT INTO job_roles (jobRoleId, roleName, location, capabilityId, bandId, closingDate, statusId, description, responsibilities, sharepointUrl, numberOfOpenPositions)
VALUES
    (1, 'Front-end Engineer', 'Birmingham', 1, 3, '2024-09-15 17:00:00', 1,
     'As a Front-end Engineer in Kainos, you will have the opportunity to use your expertise in developing high quality user interface solutions which delight our customers and impact the lives of users worldwide.',
     'The projects you will join are varied, and often highly visible. You will be working in fast- paced, agile environments, so it is important for you to make sound, reasoned decisions, and recommendations on front-end and user interfaces with your colleagues.',
     'https://kainossoftwareltd.sharepoint.com/sites/PeopleTeam-SharedDrive/Shared%20Documents/Forms/AllItems.aspx?id=%2Fsites%2FPeopleTeam%2DSharedDrive%2FShared%20Documents%2FPeople%20Team%20Shared%20Drive%2FOrganisational%20Development%20%26%20Learning%2FCareer%20Lattice%2FApproved%20Job%20Profiles%2FEngineering%2FEngineering%2FJob%20Profile%20%2D%20Front%2DEnd%20Engineer%20%28A%29%2Epdf&parent=%2Fsites%2FPeopleTeam%2DSharedDrive%2FShared%20Documents%2FPeople%20Team%20Shared%20Drive%2FOrganisational%20Development%20%26%20Learning%2FCareer%20Lattice%2FApproved%20Job%20Profiles%2FEngineering%2FEngineering&p=true&ga=1',
     3),

    (2, 'Software Engineer', 'Derry', 1, 2, '2024-09-20 17:00:00', 1,
     'As a Trainee Software Engineer with Kainos, you will work on projects where you can make
a real difference to people’s lives – the lives of people you know. After taking part in our
award-winning, seven-week Engineering Academy, you will then join one of our many
project teams, to learn from our experienced developers, project managers and
customer-facing staff. You’ll have great support and mentoring, balanced with the
experience of being given real, meaningful work to do, to help you truly develop both
technically and professionally.',
     'You will be responsible for:
• Contribute to developing high quality solutions which impact the lives of users
worldwide.
• You’ll work as part of a team to solve problems and produce innovative software
solutions.
• Learn about new technologies and approaches, with talented colleagues who will
help you learn, develop and grow.
• Based in our Kainos office and often on our customer sites, you will work on a
project teams to learn how to develop and unit test developing and unit testing
straightforward or low complexity components, and then moving on to more
complex elements as you increase your knowledge.
• Work with other developers in working through designs and user stories and to
produce real development solutions
• Will be fully supported by experienced colleagues in the team to follow designs,
and then progress to assist in any other aspect of the project life-cycle under
supervision
• Develop excellent technical, team-working and Agile project experience',
     'https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20profile%20%2D%20Software%20Engineer%20%28Trainee%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering&p=true&ga=1',
     2),

    (3, 'Test Engineer', 'Belfast', 1, 3, '2024-09-30 17:00:00', 2,
     'As a Test Engineer (Associate) in Kainos, you’ll work within a multi-skilled agile team,
developing and executing functional automated and manual tests to help the team
deliver working application software that meets user needs. You’ll do this whilst learning
about new technologies and approaches, with talented colleagues who will help you
learn, develop and grow.',
     'Using multiple technologies: Selenium, J-Unit etc. Communicating with teams, working in an agile environment, working closely with developers',
     'https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20profile%20%20Test%20Engineer%20%28Associate%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering',
     0),

    (4, 'Senior Product Specialist', 'London', 7, 4, '2024-10-05 17:00:00', 1,
     'As a Senior Product Specialist at Kainos you will be responsible for delivering high quality
solutions which delight our customers and impact the lives of users worldwide. It’s a fast-
paced environment so it is important for you to make sound, reasoned decisions. You’ll do
this whilst learning about new technologies and approaches, with talented colleagues
that will help you to learn, develop and grow as you, in turn, mentor those around you.',
     'You’ll be responsible for capturing and mapping customer needs to product capabilities,
supporting clients throughout their implementation lifecycle and business processes
changes as well as providing information to relevant engineering teams on improvements
of fixes required in the products.',
     'https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20profile%20%2D%20Senior%20Product%20Specialist%20%28SA%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering&p=true&ga=1',
     4),

    (5, 'Principal Architect', 'Gdansk', 1, 7, '2024-10-10 17:00:00', 2,
     'As a Principal Architect (Principal) in Kainos, you’ll be accountable for successful delivery
of large-scale high-quality solutions which delight our customers and impact the lives of
users worldwide.
You will provide assurance and support to multi-skilled agile teams by understanding the
outcomes the solution is trying to achieve, the technical implications and complexity
surrounding you and your teams designs and helping teams make the right decisions.',
     'You’ll work with senior stakeholders to agree architectural principles, strategic direction
and functional and non-functional designs. You will manage other architects and engineers
in the capability to help them navigate their careers.
As a technical leader, you will work with your colleagues to lead development of policy
and standards, develop customer relationships, develop account strategies and share
knowledge and mentor those around you. You’ll do this whilst advising about new
technologies and approaches, with room to learn, develop and grow.
You’ll manage, coach and develop a small number of staff, with a focus on managing
employee performance and assisting in their career development. You’ll also provide
direction and leadership for your team as you solve challenging problems together.',
     'https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20Profile%20%2D%20Principal%20Architect%20%28Principal%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering&p=true&ga=1',
     0);
