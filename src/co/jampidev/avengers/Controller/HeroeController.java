package co.jampidev.avengers.Controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jampidev.avengers.DAO.EstadoDao;
import co.jampidev.avengers.DAO.GeneroDao;
import co.jampidev.avengers.DAO.HeroeDao;
import co.jampidev.avengers.model.Estado;
import co.jampidev.avengers.model.Genero;
import co.jampidev.avengers.model.Heroe;
import co.jampidev.avengers.model.Pelicula;

/**
 * Servlet implementation class HeroeController
 */
@WebServlet("/heroe")
public class HeroeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GeneroDao generoDao = new GeneroDao();
	private EstadoDao estadoDao = new EstadoDao();
	private HeroeDao heroeDao = new HeroeDao();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HeroeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		String action = request.getParameter("action");
		try {
			switch (action) {
			case "agregar":
				vistaAgregar(request, response);
				break;
			case "eliminar":
				eliminarHeroe(request, response);
				break;
			case "editar":
				editarHeroe(request, response);
				break;
			case "buscar":
				buscarHeroe(request, response);
				break;
			case "listar":
				listarHeroes(request, response);
			case "participacion":
				participacion(request, response);
			default:
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void participacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Heroe heroe = heroeDao.find(id);
		List<Pelicula> peliculas = heroe.getPeliculas();
		request.setAttribute("heroe", heroe);
		request.setAttribute("peliculas", peliculas);
		request.getRequestDispatcher("views/listarParticipacion.jsp").forward(request, response);
	}

	private void listarHeroes(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			List<Heroe> heroes = heroeDao.list();
			request.setAttribute("heroes", heroes);
			request.getRequestDispatcher("views/listarHeroes.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void buscarHeroe(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void editarHeroe(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void eliminarHeroe(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void vistaAgregar(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			List<Genero> generos = generoDao.list();
			List<Estado> estados = estadoDao.list();
			request.setAttribute("generos", generos);
			request.setAttribute("estados", estados);
			request.getRequestDispatcher("views/crearHeroe.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		String action = request.getParameter("action");
		try {
			switch (action) {
			case "crear":
				crearHeroe(request, response);
				break;
			default:
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void crearHeroe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Genero genero = generoDao.find(request.getParameter("genero"));
		Estado estado = estadoDao.find(request.getParameter("estado"));
		Heroe nuevoHeroe = new Heroe();
		nuevoHeroe.setArma(request.getParameter("arma"));
		nuevoHeroe.setEstadoBean(estado);
		nuevoHeroe.setGeneroBean(genero);
		nuevoHeroe.setFechaaparicion(Date.valueOf(request.getParameter("fechaaparicion")));
		nuevoHeroe.setFechanacimiento(Date.valueOf(request.getParameter("fechanacimiento")));
		nuevoHeroe.setHeroe(request.getParameter("heroe"));
		nuevoHeroe.setNombre(request.getParameter("nombre"));
		heroeDao.insert(nuevoHeroe);
		listarHeroes(request, response);
	}

}
