package tr.edu.medipol.yazilimaraclari.HarmanMarket;
import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/urunlistele")
public class UrunListeleWebServisi {
	
	public record Urun( int urunSeriNo, String urunAdi, String urunMarka, double urunGramaj, double urunFiyati, String urunSKT) {}

	
	private static final List<Urun> URUN_LISTESI = new ArrayList<>();
	static {
		URUN_LISTESI.add(new Urun(0001, "Çilek", "Harman Market", 1000, 50, "05/02/2024"));
		URUN_LISTESI.add(new Urun(0002, "California Biber", "Harman Market", 500, 86, "26/01/2024"));
		URUN_LISTESI.add(new Urun(0003, "Brokoli", "Harman Market", 300, 45, "14/03/2024"));

	}

@GetMapping("/")
public List<Urun> listele(){
    return URUN_LISTESI;
}

@GetMapping("/{no}")
public Urun bul(@PathVariable int no) {
    for (Urun urun : URUN_LISTESI) {
        if (urun.urunSeriNo() == no) {
            return urun;
        }
    }
    return null;
}

@DeleteMapping("/{no}")
public boolean sil(@PathVariable int no) {
    Urun urun = bul(no);
    if(urun != null) {
        URUN_LISTESI.remove(urun);
        return true;
    }
    return false;
}

@PostMapping("/")
public Urun ekle(@RequestBody Urun urun) {
    URUN_LISTESI.add(urun);
    return urun;
}
}









