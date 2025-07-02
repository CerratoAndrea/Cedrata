
drop table scores;
drop table users;
drop table countries;

CREATE TABLE `countries` (
  `alpha2code` varchar(2) NOT NULL,
  `alpha3code` varchar(3) DEFAULT NULL,
  `capital` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `region` varchar(50) DEFAULT NULL,
  `subregion` VARCHAR(100),
  `population` varchar(50) DEFAULT NULL,
  `languages` text DEFAULT NULL,
  `area` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`alpha2code`)
);

CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(50) DEFAULT 'USER',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
);

CREATE TABLE `scores` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  `domanda` varchar(4000) DEFAULT NULL,
  `difficolta` varchar(20) DEFAULT NULL,
  `risposta_corretta` varchar(4000) DEFAULT NULL,
  `risposta_utente` varchar(4000) DEFAULT NULL,
  `corretto` tinyint(1) DEFAULT NULL,
  `data` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `sessione` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_scores_user` (`user_id`),
  CONSTRAINT `fk_scores_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);

INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('AF', 'AFG', 'Afghanistan', 'Kabul', 'Asia', '38928341', '652230', 'pashto, dari');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('AL', 'ALB', 'Albania', 'Tirana', 'Europe', '2837743', '28748', 'albanian');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('DZ', 'DZA', 'Algeria', 'Algiers', 'Africa', '43851043', '2381741', 'arabic');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('AO', 'AGO', 'Angola', 'Luanda', 'Africa', '32866268', '1246700', 'portuguese');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('AR', 'ARG', 'Argentina', 'Buenos Aires', 'Americas', '45376763', '2780400', 'spanish');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('AM', 'ARM', 'Armenia', 'Yerevan', 'Asia', '2963234', '29743', 'armenian');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('AU', 'AUS', 'Australia', 'Canberra', 'Oceania', '25687041', '7692024', 'english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('AT', 'AUT', 'Austria', 'Vienna', 'Europe', '8917205', '83871', 'german');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('AZ', 'AZE', 'Azerbaijan', 'Baku', 'Asia', '10110116', '86600', 'azerbaijani');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('BH', 'BHR', 'Bahrain', 'Manama', 'Asia', '1701583', '765', 'arabic');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('BD', 'BGD', 'Bangladesh', 'Dhaka', 'Asia', '164689383', '147570', 'bengali');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('BY', 'BLR', 'Belarus', 'Minsk', 'Europe', '9398861', '207600', 'belarusian, russian');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('BE', 'BEL', 'Belgium', 'Brussels', 'Europe', '11555997', '30528', 'dutch, french, german');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('BZ', 'BLZ', 'Belize', 'Belmopan', 'Americas', '397621', '22966', 'english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('BJ', 'BEN', 'Benin', 'Porto-Novo', 'Africa', '12123198', '112622', 'french');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('BT', 'BTN', 'Bhutan', 'Thimphu', 'Asia', '771612', '38394', 'dzongkha');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('BA', 'BIH', 'Bosnia and Herzegovina', 'Sarajevo', 'Europe', '3280815', '51209', 'bosnian, croatian, serbian');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('BW', 'BWA', 'Botswana', 'Gaborone', 'Africa', '2351625', '582000', 'english, tswana');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('BR', 'BRA', 'Brazil', 'Bras�lia', 'Americas', '212559409', '8515767', 'portuguese');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('BG', 'BGR', 'Bulgaria', 'Sofia', 'Europe', '6927288', '110879', 'bulgarian');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('BF', 'BFA', 'Burkina Faso', 'Ouagadougou', 'Africa', '20903278', '272967', 'french');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('BI', 'BDI', 'Burundi', 'Gitega', 'Africa', '11890781', '27834', 'kirundi, french, english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('KH', 'KHM', 'Cambodia', 'Phnom Penh', 'Asia', '16718971', '181035', 'khmer');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('CM', 'CMR', 'Cameroon', 'Yaound�', 'Africa', '26545864', '475442', 'english, french');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('CA', 'CAN', 'Canada', 'Ottawa', 'Americas', '38005238', '9984670', 'english, french');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('CV', 'CPV', 'Cabo Verde', 'Praia', 'Africa', '555988', '4033', 'portuguese');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('CF', 'CAF', 'Central African Republic', 'Bangui', 'Africa', '4829764', '622984', 'french, sango');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('TD', 'TCD', 'Chad', 'N''''Djamena', 'Africa', '16425859', '1284000', 'french, arabic');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('CL', 'CHL', 'Chile', 'Santiago', 'Americas', '19116209', '756102', 'spanish');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('CN', 'CHN', 'China', 'Beijing', 'Asia', '1402112000', '9640011', 'chinese');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('CO', 'COL', 'Colombia', 'Bogot�', 'Americas', '50882884', '1141748', 'spanish');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('KM', 'COM', 'Comoros', 'Moroni', 'Africa', '869595', '1862', 'arabic, french, comorian');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('CG', 'COG', 'Congo', 'Brazzaville', 'Africa', '5518092', '342000', 'french');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('CR', 'CRI', 'Costa Rica', 'San Jos�', 'Americas', '5094114', '51100', 'spanish');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('HR', 'HRV', 'Croatia', 'Zagreb', 'Europe', '4047200', '56594', 'croatian');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('CU', 'CUB', 'Cuba', 'Havana', 'Americas', '11326616', '109884', 'spanish');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('CY', 'CYP', 'Cyprus', 'Nicosia', 'Europe', '1207361', '9251', 'greek, turkish');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('CZ', 'CZE', 'Czech Republic', 'Prague', 'Europe', '10698896', '78865', 'czech');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('DK', 'DNK', 'Denmark', 'Copenhagen', 'Europe', '5831404', '43094', 'danish');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('DJ', 'DJI', 'Djibouti', 'Djibouti', 'Africa', '988002', '23200', 'french, arabic');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('DO', 'DOM', 'Dominican Republic', 'Santo Domingo', 'Americas', '10847904', '48671', 'spanish');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('EC', 'ECU', 'Ecuador', 'Quito', 'Americas', '17643060', '276841', 'spanish');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('EG', 'EGY', 'Egypt', 'Cairo', 'Africa', '102334403', '1002450', 'arabic');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('SV', 'SLV', 'El Salvador', 'San Salvador', 'Americas', '6486201', '21041', 'spanish');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('GQ', 'GNQ', 'Equatorial Guinea', 'Malabo', 'Africa', '1402985', '28051', 'spanish, french, portuguese');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('EE', 'EST', 'Estonia', 'Tallinn', 'Europe', '1331057', '45227', 'estonian');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('ET', 'ETH', 'Ethiopia', 'Addis Ababa', 'Africa', '114963583', '1104300', 'amharic');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('FJ', 'FJI', 'Fiji', 'Suva', 'Oceania', '896444', '18272', 'english, fijian, hindi');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('FI', 'FIN', 'Finland', 'Helsinki', 'Europe', '5530719', '338424', 'finnish, swedish');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('FR', 'FRA', 'France', 'Paris', 'Europe', '67391582', '640679', 'french');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('GA', 'GAB', 'Gabon', 'Libreville', 'Africa', '2225728', '267668', 'french');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('GE', 'GEO', 'Georgia', 'Tbilisi', 'Asia', '3714000', '69700', 'georgian');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('DE', 'DEU', 'Germany', 'Berlin', 'Europe', '83240525', '357114', 'german');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('GH', 'GHA', 'Ghana', 'Accra', 'Africa', '31072945', '238533', 'english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('GR', 'GRC', 'Greece', 'Athens', 'Europe', '10715549', '131990', 'greek');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('GT', 'GTM', 'Guatemala', 'Guatemala City', 'Americas', '16858333', '108889', 'spanish');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('GN', 'GIN', 'Guinea', 'Conakry', 'Africa', '13132792', '245857', 'french');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('GW', 'GNB', 'Guinea-Bissau', 'Bissau', 'Africa', '1967998', '36125', 'portuguese');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('GY', 'GUY', 'Guyana', 'Georgetown', 'Americas', '786559', '214969', 'english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('HT', 'HTI', 'Haiti', 'Port-au-Prince', 'Americas', '11402533', '27750', 'french, haitian creole');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('VA', 'VAT', 'Vatican City', 'Vatican City', 'Europe', '451', '0', 'latin, italian');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('HN', 'HND', 'Honduras', 'Tegucigalpa', 'Americas', '9904608', '112492', 'spanish');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('HK', 'HKG', 'Hong Kong', 'City of Victoria', 'Asia', '7481800', '1104', 'chinese, english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('HU', 'HUN', 'Hungary', 'Budapest', 'Europe', '9749763', '93028', 'hungarian');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('IS', 'ISL', 'Iceland', 'Reykjav�k', 'Europe', '366425', '103000', 'icelandic');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('IN', 'IND', 'India', 'New Delhi', 'Asia', '1380004385', '3287590', 'hindi, english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('ID', 'IDN', 'Indonesia', 'Jakarta', 'Asia', '273523621', '1904569', 'indonesian');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('CI', 'CIV', 'C�te d''''Ivoire', 'Yamoussoukro', 'Africa', '26378275', '322463', 'french');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('IQ', 'IRQ', 'Iraq', 'Baghdad', 'Asia', '40222503', '438317', 'arabic, kurdish');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('IE', 'IRL', 'Ireland', 'Dublin', 'Europe', '4994724', '70273', 'irish, english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('IL', 'ISR', 'Israel', 'Jerusalem', 'Asia', '9216900', '20770', 'hebrew');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('IT', 'ITA', 'Italy', 'Rome', 'Europe', '59554023', '301336', 'italian');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('JM', 'JAM', 'Jamaica', 'Kingston', 'Americas', '2961161', '10991', 'english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('JP', 'JPN', 'Japan', 'Tokyo', 'Asia', '125836021', '377930', 'japanese');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('JO', 'JOR', 'Jordan', 'Amman', 'Asia', '10203140', '89342', 'arabic');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('KZ', 'KAZ', 'Kazakhstan', 'Nur-Sultan', 'Asia', '18754440', '2724900', 'kazakh, russian');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('KE', 'KEN', 'Kenya', 'Nairobi', 'Africa', '53771300', '580367', 'swahili, english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('KW', 'KWT', 'Kuwait', 'Kuwait City', 'Asia', '4270563', '17818', 'arabic');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('KG', 'KGZ', 'Kyrgyzstan', 'Bishkek', 'Asia', '6591600', '199951', 'kyrgyz, russian');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('LA', 'LAO', 'Lao People''''s Democratic Republic', 'Vientiane', 'Asia', '7275556', '236800', 'lao');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('LV', 'LVA', 'Latvia', 'Riga', 'Europe', '1901548', '64559', 'latvian');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('LB', 'LBN', 'Lebanon', 'Beirut', 'Asia', '6825442', '10452', 'arabic');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('LS', 'LSO', 'Lesotho', 'Maseru', 'Africa', '2142252', '30355', 'english, sesotho');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('LR', 'LBR', 'Liberia', 'Monrovia', 'Africa', '5057677', '111369', 'english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('LY', 'LBY', 'Libya', 'Tripoli', 'Africa', '6871287', '1759540', 'arabic');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('LT', 'LTU', 'Lithuania', 'Vilnius', 'Europe', '2794700', '65300', 'lithuanian');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('LU', 'LUX', 'Luxembourg', 'Luxembourg', 'Europe', '632275', '2586', 'luxembourgish, french, german');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('MK', 'MKD', 'North Macedonia', 'Skopje', 'Europe', '2083380', '25713', 'macedonian');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('MG', 'MDG', 'Madagascar', 'Antananarivo', 'Africa', '27691019', '587041', 'malagasy, french');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('MW', 'MWI', 'Malawi', 'Lilongwe', 'Africa', '19129955', '118484', 'english, chichewa');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('MY', 'MYS', 'Malaysia', 'Kuala Lumpur', 'Asia', '32365998', '330803', 'malay');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('MV', 'MDV', 'Maldives', 'Mal�', 'Asia', '540542', '300', 'dhivehi');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('ML', 'MLI', 'Mali', 'Bamako', 'Africa', '20250834', '1240192', 'french');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('MT', 'MLT', 'Malta', 'Valletta', 'Europe', '525285', '316', 'maltese, english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('MR', 'MRT', 'Mauritania', 'Nouakchott', 'Africa', '4649660', '1030700', 'arabic');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('MU', 'MUS', 'Mauritius', 'Port Louis', 'Africa', '1265740', '2040', 'english, french');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('MX', 'MEX', 'Mexico', 'Mexico City', 'Americas', '128932753', '1964375', 'spanish');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('MN', 'MNG', 'Mongolia', 'Ulan Bator', 'Asia', '3278292', '1564110', 'mongolian');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('ME', 'MNE', 'Montenegro', 'Podgorica', 'Europe', '621718', '13812', 'montenegrin');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('MA', 'MAR', 'Morocco', 'Rabat', 'Africa', '36910558', '446550', 'arabic, berber');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('MZ', 'MOZ', 'Mozambique', 'Maputo', 'Africa', '31255435', '801590', 'portuguese');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('MM', 'MMR', 'Myanmar', 'Naypyidaw', 'Asia', '54409794', '676578', 'burmese');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('NA', 'NAM', 'Namibia', 'Windhoek', 'Africa', '2540916', '825615', 'english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('NP', 'NPL', 'Nepal', 'Kathmandu', 'Asia', '29136808', '147181', 'nepali');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('NL', 'NLD', 'Netherlands', 'Amsterdam', 'Europe', '17441139', '41850', 'dutch');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('NZ', 'NZL', 'New Zealand', 'Wellington', 'Oceania', '5084300', '270467', 'english, maori, nz sign language');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('NI', 'NIC', 'Nicaragua', 'Managua', 'Americas', '6624554', '130373', 'spanish');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('NE', 'NER', 'Niger', 'Niamey', 'Africa', '24206636', '1267000', 'french');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('NG', 'NGA', 'Nigeria', 'Abuja', 'Africa', '206139587', '923768', 'english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('NO', 'NOR', 'Norway', 'Oslo', 'Europe', '5379475', '323802', 'norwegian');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('OM', 'OMN', 'Oman', 'Muscat', 'Asia', '5106622', '309500', 'arabic');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('PK', 'PAK', 'Pakistan', 'Islamabad', 'Asia', '220892331', '881912', 'urdu, english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('PA', 'PAN', 'Panama', 'Panama City', 'Americas', '4314768', '75417', 'spanish');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('PG', 'PNG', 'Papua New Guinea', 'Port Moresby', 'Oceania', '8947027', '462840', 'english, hiri motu, tok pisin');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('PY', 'PRY', 'Paraguay', 'Asunci�n', 'Americas', '7132530', '406752', 'spanish, guarani');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('PE', 'PER', 'Peru', 'Lima', 'Americas', '32971846', '1285216', 'spanish, quechua, aymara');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('PH', 'PHL', 'Philippines', 'Manila', 'Asia', '109581085', '342353', 'filipino, english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('PL', 'POL', 'Poland', 'Warsaw', 'Europe', '37950802', '312679', 'polish');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('PT', 'PRT', 'Portugal', 'Lisbon', 'Europe', '10305564', '92090', 'portuguese');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('QA', 'QAT', 'Qatar', 'Doha', 'Asia', '2881060', '11586', 'arabic');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('RO', 'ROU', 'Romania', 'Bucharest', 'Europe', '19286123', '238391', 'romanian');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('RU', 'RUS', 'Russian Federation', 'Moscow', 'Europe', '144104080', '17124442', 'russian');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('RW', 'RWA', 'Rwanda', 'Kigali', 'Africa', '12952209', '26338', 'kinyarwanda, french, english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('LC', 'LCA', 'Saint Lucia', 'Castries', 'Americas', '183629', '616', 'english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('ST', 'STP', 'Sao Tome and Principe', 'S�o Tom�', 'Africa', '219161', '964', 'portuguese');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('SA', 'SAU', 'Saudi Arabia', 'Riyadh', 'Asia', '34813867', '2149690', 'arabic');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('SN', 'SEN', 'Senegal', 'Dakar', 'Africa', '16743930', '196722', 'french');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('RS', 'SRB', 'Serbia', 'Belgrade', 'Europe', '6908224', '88361', 'serbian');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('SC', 'SYC', 'Seychelles', 'Victoria', 'Africa', '98462', '452', 'english, french, seychellois creole');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('SL', 'SLE', 'Sierra Leone', 'Freetown', 'Africa', '7976985', '71740', 'english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('SG', 'SGP', 'Singapore', 'Singapore', 'Asia', '5685807', '710', 'english, malay, mandarin, tamil');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('SK', 'SVK', 'Slovakia', 'Bratislava', 'Europe', '5458827', '49037', 'slovak');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('SI', 'SVN', 'Slovenia', 'Ljubljana', 'Europe', '2100126', '20273', 'slovene');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('SO', 'SOM', 'Somalia', 'Mogadishu', 'Africa', '15893219', '637657', 'somali, arabic');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('ZA', 'ZAF', 'South Africa', 'Pretoria', 'Africa', '59308690', '1221037', 'zulu, xhosa, afrikaans, english, northern sotho');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('SS', 'SSD', 'South Sudan', 'Juba', 'Africa', '11193729', '619745', 'english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('ES', 'ESP', 'Spain', 'Madrid', 'Europe', '47351567', '505992', 'spanish');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('LK', 'LKA', 'Sri Lanka', 'Sri Jayawardenepura Kotte', 'Asia', '21919000', '65610', 'sinhala, tamil');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('SD', 'SDN', 'Sudan', 'Khartoum', 'Africa', '43849269', '1886068', 'arabic, english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('SR', 'SUR', 'Suriname', 'Paramaribo', 'Americas', '586634', '163820', 'dutch');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('SZ', 'SWZ', 'Eswatini', 'Mbabane', 'Africa', '1160164', '17364', 'english, swazi');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('SE', 'SWE', 'Sweden', 'Stockholm', 'Europe', '10353442', '450295', 'swedish');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('CH', 'CHE', 'Switzerland', 'Bern', 'Europe', '8636896', '41284', 'german, french, italian, romansh');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('SY', 'SYR', 'Syrian Arab Republic', 'Damascus', 'Asia', '17500657', '185180', 'arabic');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('TW', 'TWN', 'Taiwan', 'Taipei', 'Asia', '23503349', '36193', 'mandarin');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('TJ', 'TJK', 'Tajikistan', 'Dushanbe', 'Asia', '9537642', '143100', 'tajik');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('TZ', 'TZA', 'Tanzania', 'United Republic of', 'Dodoma', '59734213', '59734213', 'english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('TH', 'THA', 'Thailand', 'Bangkok', 'Asia', '69799978', '513120', 'thai');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('TL', 'TLS', 'Timor-Leste', 'Dili', 'Asia', '1318442', '14874', 'portuguese, tetum');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('TG', 'TGO', 'Togo', 'Lom�', 'Africa', '8278737', '56785', 'french');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('TT', 'TTO', 'Trinidad and Tobago', 'Port of Spain', 'Americas', '1399491', '5130', 'english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('TN', 'TUN', 'Tunisia', 'Tunis', 'Africa', '11818618', '163610', 'arabic');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('TR', 'TUR', 'Turkey', 'Ankara', 'Asia', '84339067', '783562', 'turkish');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('TM', 'TKM', 'Turkmenistan', 'Ashgabat', 'Asia', '6031187', '488100', 'turkmen');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('UG', 'UGA', 'Uganda', 'Kampala', 'Africa', '45741000', '241550', 'english, swahili');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('UA', 'UKR', 'Ukraine', 'Kyiv', 'Europe', '44134693', '603700', 'ukrainian');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('AE', 'ARE', 'United Arab Emirates', 'Abu Dhabi', 'Asia', '9890400', '83600', 'arabic');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('GB', 'GBR', 'United Kingdom', 'London', 'Europe', '67886004', '242900', 'english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('US', 'USA', 'United States of America', 'Washington', 'D.C.', '329484123', '329484123', 'english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('UY', 'URY', 'Uruguay', 'Montevideo', 'Americas', '3473727', '181034', 'spanish');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('UZ', 'UZB', 'Uzbekistan', 'Tashkent', 'Asia', '34232050', '447400', 'uzbek');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('VN', 'VNM', 'Vietnam', 'Hanoi', 'Asia', '97338583', '331212', 'vietnamese');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('YE', 'YEM', 'Yemen', 'Sana''''a', 'Asia', '29825968', '527968', 'arabic');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('ZM', 'ZMB', 'Zambia', 'Lusaka', 'Africa', '18383956', '752612', 'english');
INSERT INTO countries (alpha2code, alpha3code, name, capital, region, population, area, languages) VALUES ('ZW', 'ZWE', 'Zimbabwe', 'Harare', 'Africa', '14862927', '390757', 'english, shona, sindebele');
commit;
