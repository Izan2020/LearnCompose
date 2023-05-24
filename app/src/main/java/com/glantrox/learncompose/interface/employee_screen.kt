package com.glantrox.learncompose.`interface`

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.glantrox.learncompose.R
import com.glantrox.learncompose.core.dataclasses.models.EmployeeModel
import com.glantrox.learncompose.ui.theme.LearnComposeTheme
import com.glantrox.learncompose.utils.AppUtil

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmployeeScreenUI(navController: NavController) {
    val context: Context = LocalContext.current
    val urlDefault = "https://1fid.com/wp-content/uploads/2022/06/no-profile-picture-6-1024x1024.jpg"
    val employees: List<EmployeeModel> = listOf(
        EmployeeModel(3, "Hamas", "Karyawan", urlDefault),
        EmployeeModel(1, "Antonnio", "Manager", urlDefault),
        EmployeeModel(2, "Nexon", "Bos", urlDefault),
        EmployeeModel(7, "Raavfy", "Wakil Bos", urlDefault),
        EmployeeModel(8, "Rama", "Sales", urlDefault),
        EmployeeModel(5, "Falah", "Karyawan", urlDefault),
        EmployeeModel(4, "Ahmad", "Manager", urlDefault),
        EmployeeModel(6, "Fayiz", "Manager", urlDefault),
    )
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ },
                content = {
                    Icon(
                        painter = painterResource(R.drawable.baseline_add_24),
                        contentDescription = "Add Employees") })
        },
        topBar = {
                 TopAppBar(
                     colors = TopAppBarDefaults.mediumTopAppBarColors(
                         containerColor = Color.DarkGray
                     ),
                     title = {
                         Text("Daftar Karyawan",
                                style = TextStyle(
                                    color = Color.White,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 22.sp
                                )
                             )
                     }
                 )
        },
        content = {
            LazyColumn(
                modifier = Modifier.padding(it)
            ) {
                items(employees) {
                    EmployeeItem(employee = it, context)
                }
            }
        }
    )
}

@Composable
fun EmployeeItem(employee: EmployeeModel, context: Context) {
    Card(
        shape = RoundedCornerShape(10),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 3.dp, vertical = 2.dp)
            .clickable {
                       AppUtil().toast(context,"Anda memilih pegawai ${employee.name}")
            },
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(model = employee.imageUrl ,
                    contentDescription = null,
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape)
                    )
                Column(
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text(employee.name,
                        style = TextStyle(
                            fontWeight = FontWeight.Medium,
                                    fontSize = 16.sp
                        )
                        )
                    Text(employee.jabatan,
                        style = TextStyle(
                            fontWeight = FontWeight.Light,

                        )
                    )
                }
            }
            IconButton(onClick = {
                Toast
                    .makeText(context, "Dia adalah ${employee.jabatan}", Toast.LENGTH_SHORT)
                    .show()
            },
                content = {
                    Icon(
                        painter = painterResource(R.drawable.baseline_more_vert_24),
                        contentDescription = "share") }
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewEmployeeScreen() {
    LearnComposeTheme {
        EmployeeScreenUI(rememberNavController())
    }
}