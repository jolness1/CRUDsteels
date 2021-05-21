DELETE
FROM steel;

DELETE
FROM application;

INSERT INTO steel (steelid, steelname, manufacturer, steeldescription, rockwellhardness, sharpening, edgeretention, stainless)
        VALUES (0, 'M390', 'Bohler-Uddeholm' , 'Popular', '60-62', '8', '10', '8'),
               (1, 'K390', 'Bohler-Uddeholm' , 'Super D2 type steel', '62-64', '7', '10', '2')

INSERT INTO application (applicationid, steel)