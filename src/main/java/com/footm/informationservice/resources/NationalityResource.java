package com.footm.informationservice.resources;

import com.footm.informationservice.api.Nationality;
import com.footm.informationservice.api.Player;
import com.footm.informationservice.db.NationalityDao;
import com.footm.informationservice.db.PlayerDao;
import org.jdbi.v3.core.Jdbi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("nationalities")
@Produces(MediaType.APPLICATION_JSON)
public class NationalityResource {

    private Jdbi jdbdi;

    public NationalityResource(Jdbi jdbdi){
        this.jdbdi=jdbdi;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Nationality> getListNationalities(){
        return jdbdi.withExtension(NationalityDao.class, dao -> dao.getListNationalities());
    }

    @GET
    @Path("/{nationalityId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Player> getPlayersInNationality(@PathParam("nationalityId") String nationalityId){
        return jdbdi.withExtension(PlayerDao.class, dao -> dao.getPlayersInNationality(nationalityId));
    }
}