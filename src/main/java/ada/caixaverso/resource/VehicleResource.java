package ada.caixaverso.resource;

import ada.caixaverso.dto.UpdateVehicleRequestBody;
import ada.caixaverso.dto.VehicleRequestBody;
import ada.caixaverso.dto.VehicleResponseBody;
import ada.caixaverso.model.Vehicle;
import ada.caixaverso.repository.VehicleRepository;
import ada.caixaverso.service.VehicleService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/api/v1/vehicles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VehicleResource {

    private VehicleService vehicleService;

    private VehicleResource(){
        vehicleService = new VehicleService(new VehicleRepository());
  ; }

    @POST
    public Response create(VehicleRequestBody body){
        try{
            VehicleResponseBody vehicle = vehicleService.create( body );
            return Response.created(URI.create("/api/v1/vehicles/" + vehicle.id())).build();
        }catch (IllegalArgumentException e){
            return Response.status( Response.Status.BAD_REQUEST).build();
        }
    }

    @GET
    @Path("{id}")
    public Response findById(@PathParam("id") Long id){

        try{
            VehicleResponseBody body = vehicleService.findById(id);
            return Response.ok( body ).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @GET
    public Response listAll(){
        List<VehicleResponseBody> body = vehicleService.findAll();
        return Response.ok( body ).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id){
        vehicleService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PATCH
    @Path("{id}")
    public Response update(@PathParam("id") Long id, UpdateVehicleRequestBody body) {
        vehicleService.update(id,body);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
