package br.com.fiap.banco.resource;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.Cliente;
import br.com.fiap.banco.service.ClienteService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/cliente")// http://localhost:8080/SprintJavaPorto/api/cliente
public class ClienteResource {

	private ClienteService service;

	public ClienteResource() throws ClassNotFoundException, SQLException {
		service = new ClienteService();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Cliente cliente, @Context UriInfo uri) throws ClassNotFoundException, SQLException {
		try {
			service.cadastrar(cliente);
			UriBuilder uriBuilder = uri.getAbsolutePathBuilder();
			uriBuilder.path((cliente.getNome()));
			return Response.created(uriBuilder.build()).build();
		} catch (BadInfoException e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> lista() throws ClassNotFoundException, SQLException {
		return service.listar();
	}

	@DELETE
	@Path("/{nome}")
	public Response remover(@PathParam("nome") String nome) throws ClassNotFoundException, SQLException {
		try {
			service.remover(nome);
			return Response.noContent().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@PUT
	@Path("/{nome}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Cliente cliente, @PathParam("nome") String nome)
			throws ClassNotFoundException, SQLException {
		try {
			cliente.setNome(nome);
			service.atualizar(cliente);
			return Response.ok().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (BadInfoException e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

}
