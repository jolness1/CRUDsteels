DELETE
FROM steel;

DELETE
FROM knifetype;

DELETE
FROM steelknifetype;

INSERT INTO steel (steelid,steelname, manufacturer, steeldescription, rockwellhardness, sharpening, edgeretention, stainless)
    VALUES (0, 'M390', 'Bohler-Uddeholm' , 'Popular', '60-62', '8', '10', '8'),
           (1, 'K390', 'Bohler-Uddeholm' , 'Super D2 type steel', '62-64', '7', '10', '2');

INSERT INTO knifetype (knifetypeid, knifetype)
    VALUES (0, 'Axe'),
           (1, 'Pocket Knife'),
           (2, 'Chef Knife');

INSERT INTO steelknifetype (steelid, knifetypeid)
    VALUES (0, 0),
           (0, 1);


