package ba.unsa.etf.rpr23;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LaptopDaoJSONFile implements LaptopDao {
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoJSONFile(File file) {
        this.file = file;
        laptopi = new ArrayList<>();
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        List<Laptop> listaIzDatoteke = vratiPodatkeIzDatoteke();
        listaIzDatoteke.add(laptop);
        try (FileWriter writer = new FileWriter(file)) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(writer, listaIzDatoteke);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException {
        for (Laptop laptop : laptopi) {
            if (laptop.getProcesor().equals(procesor)) {
                return laptop;
            }
        }
        throw new NeodgovarajuciProcesorException("Nema laptopa s traženim procesorom: " + procesor);
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi = laptopi;
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        ArrayList<Laptop> listaIzDatoteke = new ArrayList<>();
        try (FileReader reader = new FileReader(file)) {
            ObjectMapper objectMapper = new ObjectMapper();
            listaIzDatoteke = objectMapper.readValue(reader, new TypeReference<List<Laptop>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaIzDatoteke;
    }
}

