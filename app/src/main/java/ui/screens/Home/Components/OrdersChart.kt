package ui.screens.Home.Components

import androidx.compose.runtime.Composable
import data.entity.Order
import data.repository.AppRepositoryProvider

@Composable
fun OrdersChart(){
    /*val repository = AppRepositoryProvider.ordersRepository
    val orders:List<Order> = repository.orders.value ?: emptyList()
    val data = CastOrdersToBarDataList(orders)
    BarChart(
        data = { data },
        color = ChartyColor.Solid(ChartyColors.Blue),
        barConfig = BarChartConfig(
            barWidthFraction = 0.6f,
        ),
    )*/
}

/*fun CastOrdersToBarDataList(orders:List<Order>):List<BarData>{
    val barDataList = mutableListOf<BarData>()
    orders.forEach({
        barDataList.add(BarData("Order: #${it.carId}", 100f))
    })
    return emptyList()
}*/