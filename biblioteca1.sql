DROP table prestamos;
DROP table libros;

CREATE DATABASE IF NOT EXISTS biblioteca1;
USE biblioteca1;

-- Crear la tabla libros
CREATE TABLE IF NOT EXISTS libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    genero VARCHAR(100) NOT NULL,
    disponible BOOLEAN NOT NULL
);


-- Insertar los registros en la tabla libros
INSERT INTO libros (titulo, autor, genero, disponible) VALUES
('1984', 'George Orwell', 'Ciencia ficcion', true),
('Lagun izoztua', 'Joseba Sarrionandia', 'Euskal literatura', true),
('Diez negritos', 'Agatha Christie', 'Novela policiaca', true),
('Los hombres me explican cosas', 'Rebecca Solnit', 'Ensayo', true),
('A las ocho en el Bule', 'Xabier Silveira', 'Narrativa', true),
('Politica del malestar', 'Alicia Valdes', 'Politica', true),
('Ostegunak', 'Jon Arretxe', 'Euskal literatura', true),
('Fahrenheit 451', 'Ray Bradbury', 'Ciencia ficcion', true),
('El nombre de la rosa', 'Umberto Eco', 'Novela historica', true),
('Ensayo sobre la ceguera', 'José Saramago', 'Filosofia', true),
('Harri eta herri', 'Gabriel Aresti', 'Euskal literatura', true),
('La conjura de los necios', 'John Kennedy Toole', 'Humor', true),
('El silencio de los corderos', 'Thomas Harris', 'Novela policiaca', true),
('Sapiens: De animales a dioses', 'Yuval Noah Harari', 'Historia', true),
('El guardian entre el centeno', 'J.D. Salinger', 'Novela', true),
('Rayuela', 'Julio Cortázar', 'Narrativa', true),
('El Hobbit', 'J.R.R. Tolkien', 'Fantasia', true),
('Los pilares de la Tierra', 'Ken Follett', 'Novela historica', true),
('El coronel no tiene quien le escriba', 'Gabriel García Márquez', 'Narrativa', true),
('Moby Dick', 'Herman Melville', 'Aventura', true),
('Eneida', 'Virgilio', 'Epica', true),
('Kafka en la orilla', 'Haruki Murakami', 'Ficcion', true),
('Americanah', 'Chimamanda Ngozi Adichie', 'Narrativa', true),
('Crónica de una muerte anunciada', 'Gabriel García Márquez', 'Novela', true);

-- Crear la tabla prestamos
CREATE TABLE IF NOT EXISTS prestamos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    libro_id INT NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_devolucion DATE NULL,
    FOREIGN KEY (libro_id) REFERENCES libros(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Insertar los registros en la tabla prestamos
INSERT INTO prestamos (libro_id, fecha_inicio, fecha_devolucion) VALUES
(1,  '2024-10-10', '2024-10-24'),
(6, '2024-12-13', '2024-12-27'),
(3, '2024-11-15', '2024-11-30'),
(4, '2024-09-20', '2024-10-05'),
(5, '2024-10-01', '2024-10-15'),
(7, '2024-10-25', '2024-11-10'),
(2, '2024-12-19', '2024-12-19');


select * from prestamos;
select * from libros;



