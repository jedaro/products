	DROP TABLE IF EXISTS tblproductpt;
	DROP TABLE IF EXISTS tblcompanypt;
	DROP TABLE IF EXISTS tblboxtypept;
	DROP TABLE IF EXISTS tblinventorypt;
	DROP TABLE IF EXISTS tblcustomerpt;

	CREATE TABLE tblproductpt (
		id              INTEGER NOT NULL AUTO_INCREMENT COMMENT 'sequence',
		name            VARCHAR(80) COMMENT 'Product name.',
		freshCutValue   DECIMAL(5, 2) NOT NULL DEFAULT 0 COMMENT 'Percentage fresh Cut Value.'
	);

	CREATE TABLE tblcompanypt (
		id          INTEGER NOT NULL AUTO_INCREMENT COMMENT 'sequence',
		name        VARCHAR(80) COMMENT 'Company name.'
	);

	CREATE TABLE tblboxtypept (
		id       INTEGER NOT NULL AUTO_INCREMENT COMMENT 'sequence',
		code     VARCHAR(80) COMMENT 'Code box type.',
		width    DECIMAL(10, 5) NOT NULL DEFAULT 0 COMMENT 'White box type',
		height   DECIMAL(10, 5) NOT NULL DEFAULT 0 COMMENT 'Height box type',
		length   DECIMAL(10, 5) NOT NULL DEFAULT 0 COMMENT 'Length box type'
	);

	CREATE TABLE tblinventorypt (
		id               INTEGER NOT NULL AUTO_INCREMENT COMMENT 'sequence',
		boxTypeId        INTEGER NOT NULL COMMENT 'Product box type in inventory',
		productId        INTEGER NOT NULL COMMENT 'Product Id',
		companyId        INTEGER NOT NULL COMMENT 'Company Id',
		cubesPerCarrier  DECIMAL(19, 5) NOT NULL DEFAULT 0 COMMENT 'Cubes per carrier',
		pack             INTEGER NOT NULL COMMENT 'Pack',
		basePrice        DECIMAL(10, 5) NOT NULL DEFAULT 0 COMMENT 'Base price'
	);

	CREATE TABLE tblcustomerpt (
		id       INTEGER NOT NULL AUTO_INCREMENT COMMENT 'sequence',
		name     VARCHAR(80) COMMENT 'Customer name.',
		markdown DECIMAL(5, 2) NOT NULL DEFAULT 0 COMMENT 'Markdown Percentage discount.'
	);
		