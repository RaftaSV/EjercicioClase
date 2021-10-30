package com.desarrollo.ejercicioclase

import android.app.Activity
import android.app.TaskInfo
import android.hardware.input.InputManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var et_nombre: EditText
    private lateinit var et_apellido: EditText
    private lateinit var sp_departamento: Spinner
    private lateinit var sp_municipio: Spinner
    private lateinit var rb_mujer: RadioButton
    private lateinit var rb_hombre: RadioButton
    private lateinit var et_telefono: EditText
    private lateinit var tv_mostrar: TextView
    var municipios = mutableListOf(
        "Municipios"
    )
    private var lista = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et_nombre = findViewById(R.id.txt_nombre)
        et_apellido = findViewById(R.id.txt_apellido)
        sp_departamento = findViewById(R.id.sp_departamento)
        sp_municipio = findViewById(R.id.sp_Municipio)
        rb_mujer = findViewById(R.id.rb_Mujer)
        rb_hombre = findViewById(R.id.rb_Hombre)
        et_telefono = findViewById(R.id.txt_telefono)
        tv_mostrar = findViewById(R.id.tv_mostrar)
        rb_mujer.isChecked=true
        var Departamentos = mutableListOf(
            " Departamentos",
            "Ahuachapán",
            "Santa Ana",
            "Sonsonate",
            "Usulután",
            "San Miguel",
            "Morazan",
            "La Union",
            "Chalatenango",
            "La Libertad",
            "Cuscatlan",
            "San Salvador",
            "La Paz",
            "Cabañas",
            "San Vicente"
        )
 Departamentos = Departamentos.sorted() as MutableList<String>

        val adaptadorDepartamentos =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, Departamentos)
        sp_departamento.adapter = adaptadorDepartamentos


        var adaptadorMunicipios =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, municipios)
            sp_municipio.adapter = adaptadorMunicipios


        sp_departamento.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                cambioDepartamento()
            }

        }
        adaptadorMunicipios = ArrayAdapter(this, android.R.layout.simple_spinner_item, municipios)
        sp_municipio.adapter = adaptadorMunicipios


    }
    fun cambioDepartamento(){

        var ahuachapan= arrayOf("Ahuachapán","Apaneca","Atiquizaya","Concepción de Ataco","El Refugio","Guaymango","Jujutla","San Francisco Menéndez","San Lorenzo","San Pedro Puxtla","Tacuba","Turín")
        var cabanas=arrayOf("Cinquera","Dolores (Villa Doleres)","Guacotecti","Ilobasco","Jutiapa","San Isidro","Sensuntepeque","Tejutepeque","Victoria")
        var chalatenango=arrayOf("Agua Caliente","Arcatao","Azacualpa","Chalatenango","Citalá","Comalapa","Concepción Quezaltepeque","Dulce Nombre de María","El Carrizal","El Paraíso","La Laguna","La Palma","La Reina","Las Vueltas","Nombre de Jesús","Nueva Concepción","Nueva Trinidad","Ojos de Agua","Potonico","San Antonio de la Cruz","San Antonio Los Ranchos","San Fernando","San Francisco Lempa","San Francisco Morazán","San Ignacio","San Isidro Labrador","San José Cancasque (Cancasque)","San José Las Flores","San Luis del Carmen","San Miguel de Mercedes","San Rafael","Santa Rita","Tejutla")
        var cuscatlan=arrayOf("Candelaria","Cojutepeque","El Carmen","El Rosario","Monte San Juan","Oratorio de Concepción","San Bartolomé Perulapía","San Cristóbal","San José Guayabal","San Pedro Perulapán","San Rafael Cedros","San Ramón","Santa Cruz Analquito","Santa Cruz Michapa","Suchitoto","Tenancingo")
        var morazan=arrayOf("Arambala","Cacaopera","Chilanga","Corinto","Delicias de Concepción","El Divisadero","El Rosario","Gualococti","Guatajiagua","Joateca","Jocoaitique","Jocoro","Lolotiquillo","Meanguera","Osicala","Perquín","San Carlos","San Fernando","San Francisco Gotera","San Isidro","San Simón","Sensembra","Sociedad","Torola","Yamabal","Yoloaiquín")
        var lalibertad=arrayOf("Antiguo Cuscatlán","Chiltiupán","Ciudad Arce","Colón","Comasagua","Huizúcar","Jayaque","Jicalapa","La Libertad","Santa Tecla (Nueva San Salvador)","Nuevo Cuscatlán","San Juan Opico","Quezaltepeque","Sacacoyo","San José Villanueva","San Matías","San Pablo Tacachico","Talnique","Tamanique","Teotepeque","Tepecoyo","Zaragoza")
        var lapaz=arrayOf("Cuyultitán","El Rosario (Rosario de La Paz)","Jerusalén","Mercedes La Ceiba","Olocuilta","Paraíso de Osorio","San Antonio Masahuat","San Emigdio","San Francisco Chinameca","San Juan Nonualco","San Juan Talpa","San Juan Tepezontes","San Luis La Herradura","San Luis Talpa","San Miguel Tepezontes","San Pedro Masahuat","San Pedro Nonualco","San Rafael Obrajuelo","Santa María Ostuma","Santiago Nonualco","Tapalhuaca","Zacatecoluca")
        var launion=arrayOf("Anamorós","Bolívar","Concepción de Oriente","Conchagua","El Carmen","El Sauce","Intipucá","La Unión","Lilisque","Meanguera del Golfo","Nueva Esparta","Pasaquina","Polorós","San Alejo","San José","Santa Rosa de Lima","Yayantique","Yucuaiquín")
        var sanmiguel=arrayOf("Carolina","Chapeltique","Chinameca","Chirilagua","Ciudad Barrios","Comacarán","El Tránsito","Lolotique","Moncagua","Nueva Guadalupe","Nuevo Edén de San Juan","Quelepa","San Antonio del Mosco","San Gerardo","San Jorge","San Luis de la Reina","San Miguel","San Rafael Oriente","Sesori","Uluazapa")
        var sansalvador=arrayOf("Aguilares","Apopa","Ayutuxtepeque","Ciuddad Delgado","Cuscatancingo","El Paisnal","Guazapa","Ilopango","Mejicanos","Nejapa","Panchimalco","Rosario de Mora","San Marcos","San Martín","San Salvador","Santiago Texacuangos","Santo Tomás","Soyapango","Tonacatepeque")
        var sanvicente=arrayOf("Apastepeque","Guadalupe","San Cayetano Istepeque","San Esteban Catarina","San Ildefonso","San Lorenzo","San Sebastián","San Vicente","Santa Clara","Santo Domingo","Tecoluca","Tepetitán","Verapaz")
        var santaana=arrayOf("Candelaria de la Frontera","Chalchuapa","Coatepeque","El Congo","El Porvenir","Masahuat","Metapán","San Antonio Pajonal","San Sebastián Salitrillo","Santa Ana","Santa Rosa Guachipilín","Santiago de la Frontera","Texistepeque")
        var sonsonate=arrayOf("Acajutla","Armenia","Caluco","Cuisnahuat","Izalco","Juayúa","Nahuizalco","Nahulingo","Salcoatitán","San Antonio del Monte","San Julián","Santa Catarina Masahuat","Santa Isabel Ishuatán","Santo Domingo de Guzmán","Sonsonate","Sonzacate")
        var usulutan=arrayOf("Alegría","Berlín","California","Concepción Batres","El Triunfo","Ereguayquín","Estanzuelas","Jiquilisco","Jucuapa","Jucuarán","Mercedes Umaña","Nueva Granada","Ozatlán","Puerto El Triunfo","San Agustín","San Buenaventura","San Dionisio","San Francisco Javier","Santa Elena","Santa María","Santiago de María","Tecapán","Usulután")

        var Departamentoselecionado = sp_departamento.selectedItem.toString()
        municipios.clear()
        municipios.add("Municipios")
        sp_municipio.setSelection(0)
        if (Departamentoselecionado.equals("Chalatenango")){
            municipios.addAll(chalatenango)

        }else if(Departamentoselecionado.equals("Ahuachapán")){
            municipios.addAll(ahuachapan)
        }else if(Departamentoselecionado.equals("Santa Ana")){
            municipios.addAll(santaana)
        }else if(Departamentoselecionado.equals("Sonsonate")){
            municipios.addAll(sonsonate)
        }else if(Departamentoselecionado.equals("Usulután")){
            municipios.addAll(usulutan)
        }else if(Departamentoselecionado.equals("Usulután")){
            municipios.addAll(usulutan)
        }else if(Departamentoselecionado.equals("San Miguel")){
            municipios.addAll(sanmiguel)
        }else if(Departamentoselecionado.equals("Morazan")){
            municipios.addAll(morazan)
        }else if(Departamentoselecionado.equals("La Union")){
            municipios.addAll(launion)
        }else if(Departamentoselecionado.equals("La Libertad")){
            municipios.addAll(lalibertad)
        }else if(Departamentoselecionado.equals("Cuscatlan")){
            municipios.addAll(cuscatlan)
        }else if(Departamentoselecionado.equals("San Salvador")){
            municipios.addAll(sansalvador)
        }else if(Departamentoselecionado.equals("La Paz")){
            municipios.addAll(lapaz)
        }else if(Departamentoselecionado.equals("Cabañas")){
            municipios.addAll(cabanas)
        }else if(Departamentoselecionado.equals("San Vicente")){
            municipios.addAll(sanvicente)
        }
        else{
            sp_municipio.setSelection(0)

        }
    }
    fun guardar(Vista: View){
        var nombre = et_nombre.text.toString()
        var apellido = et_apellido.text.toString()
        var departamento = sp_departamento.selectedItem.toString()
        var municipio = sp_municipio.selectedItem.toString()
        var sexo = ""
        if (rb_mujer.isChecked==true){
            sexo="Mujer"
        }else{

            sexo="Hombre"
        }
        var telefono = et_telefono.text.toString()

        if (nombre.length ==0) {
            Toast.makeText(this, "Debe agragar nombre", Toast.LENGTH_SHORT).show()
            et_nombre.requestFocus()
            val inputMethodManager =
                getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                 inputMethodManager.showSoftInput(et_nombre, InputMethodManager.SHOW_IMPLICIT);

        }else if (apellido.length==0){
            Toast.makeText(this,"Debe agregar el apellido",Toast.LENGTH_SHORT).show()
            et_apellido.requestFocus()
            val metodoEntrada = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            metodoEntrada.showSoftInput(et_apellido,InputMethodManager.SHOW_IMPLICIT)
        }else if (departamento.equals(" Departamentos")){
            Toast.makeText(this,"Debe elegir un departamento",Toast.LENGTH_SHORT).show()
            sp_departamento.performClick()
        }else if(municipio.equals("Municipios")){

            Toast.makeText(this,"Debe de elegir un municipio",Toast.LENGTH_SHORT).show()
            sp_municipio.performClick()
        }else if(telefono.length==0 || telefono.length>8){
            Toast.makeText(this, "Debe de agregar un numero telefonico valido",Toast.LENGTH_SHORT).show()
            et_telefono.requestFocus()
            val metodoEntrada = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            metodoEntrada.showSoftInput(et_telefono,InputMethodManager.SHOW_IMPLICIT)
        }else{
            var listaRegistro = mutableListOf(nombre,apellido,departamento,municipio,sexo,telefono)
            lista.addAll(listaRegistro)


            Toast.makeText(this,"Guardado Exitoso", Toast.LENGTH_SHORT).show()
            et_nombre.setText("")
            et_apellido.setText("")
            et_telefono.setText("")
            rb_mujer.isChecked=true
            sp_departamento.setSelection(0)
            cambioDepartamento()
            et_nombre.requestFocus()

        }

    }

    fun mostrar (Vista:View){

        val metodoEntrada = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        metodoEntrada.hideSoftInputFromWindow(Vista.windowToken,0)
        var contador: Int = 0
        tv_mostrar.setText("")
        var listamostrar = ""

        for (i in lista){
            if (contador==0){
                listamostrar+=("Nombre: "+ i.toString())
                contador=1
            }else if (contador==1){
                listamostrar+=(", "+ i.toString())
                contador=2
            }else if (contador==2){
                listamostrar+=(", Departamento: "+ i.toString())
                contador =3
            }else if (contador==3){
                listamostrar+=(", Municipio: "+ i.toString())
                contador =4
            }else if (contador==4){
                listamostrar+=(", Sexo: "+ i.toString())
                contador =5
            }else if (contador==5){
                listamostrar+=(", Telefono: "+ i.toString()+ System.getProperty("line.separator") )
                contador=0

            }

        }
        tv_mostrar.setText(listamostrar)


    }

}