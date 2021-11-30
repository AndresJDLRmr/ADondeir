package data

import com.example.adondeirnuevoleon.R

class Datasource {
    fun loadPlaces(): List<Places>{
        return listOf<Places>(
            Places(R.string.fundidoraName, R.string.fundidoraHorario, R.string.fundidoraLugar, R.drawable.fundidora),
            Places(R.string.grutasName, R.string.grutasHorario, R.string.grutasLugar, R.drawable.grutasgarcia),
            Places(R.string.santaLuciaName, R.string.santaLuciaHorario, R.string.santaLuciaLugar, R.drawable.santalucia),
            Places(R.string.muneName, R.string.muneHorario, R.string.muneLugar, R.drawable.mune),
            Places(R.string.bustamenteName, R.string.bustamanteHorario, R.string.bustamanteLugar, R.drawable.grutasbustamante),
            Places(R.string.zoologicoName, R.string.zoologicoHorario, R.string.zoologicoLugar, R.drawable.lapastora),
            Places(R.string.colaDeCaballoName, R.string.colaDeCaballoHorario, R.string.colaDeCaballoLugar, R.drawable.colacaballo),
            Places(R.string.huastecaName, R.string.huastecaHorario, R.string.huastecaLugar, R.drawable.huasteca)
        )
    }
}