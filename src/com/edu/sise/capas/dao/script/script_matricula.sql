/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  meryj
 * Created: 4 nov. 2021
 */


DELIMITER//
CREATE PROCEDURE pa_listar_provincias()
BEGIN
	SELECT * FROM Provincias;
END;

//DELIMITER ;
