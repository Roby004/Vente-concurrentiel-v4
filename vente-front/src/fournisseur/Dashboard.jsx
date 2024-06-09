// DashboardPage.jsx
import React from 'react';
import {useState,useEffect} from 'react';
import ResponsiveAppBar from '../components/navbar';
import { Container,Box,Button} from '@mui/material';
import './dash.css';
import { LineChart } from '@mui/x-charts/LineChart';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import Stack from '@mui/material/Stack';
import { PieChart } from '@mui/x-charts/PieChart';
import CardStatistic from '../components/CardStatistic';
import AccessAlarmIcon from '@mui/icons-material/AccessAlarm';
import { axisClasses } from '@mui/x-charts/ChartsAxis';

import { MoneySharp } from '@mui/icons-material';
import AnalyticsIcon from '@mui/icons-material/Analytics';
import { useTheme } from '@mui/material/styles';

//Nav bar

import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import Menu from '@mui/material/Menu';
import MenuIcon from '@mui/icons-material/Menu';
import Avatar from '@mui/material/Avatar';
import Tooltip from '@mui/material/Tooltip';
import MenuItem from '@mui/material/MenuItem';
import AdbIcon from '@mui/icons-material/Adb';
import InputBase from '@mui/material/InputBase';
//Icones
import SearchIcon from '@mui/icons-material/Search';
import PersonIcon from '@mui/icons-material/Person';
import HelpIcon from '@mui/icons-material/Help';
import LogoutIcon from '@mui/icons-material/Logout';
import { styled, alpha } from '@mui/material/styles';
import { Link } from 'react-router-dom'; 

// tableau

import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import {
  LinePlot,
  MarkPlot,
  lineElementClasses,
  markElementClasses,
} from '@mui/x-charts/LineChart';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import axios from 'axios';
// Material Dashboard 2 React components
//import MDBox from "../components/MDBox/index.js";

/*const data = [
  { label: 'Produit A', value: 400 },
  { label: 'Produit B', value: 300 },
  { label: 'Produit C', value: 300 },
  { label: 'Produit D', value: 200 },
];*/

//Coleur des charts
const palette = ['#ffc107', '#ff5722', '#de5273', '#febb3d'];

const StyledTableCell = styled(TableCell)(({ theme }) => ({
  [`&.${tableCellClasses.head}`]: {
    backgroundColor: 'transparent',
    color:'#d05420',
  },
  [`&.${tableCellClasses.body}`]: {
    fontSize: 14,
  },
}));

const StyledTableRow = styled(TableRow)(({ theme }) => ({
  '&:nth-of-type(odd)': {
    backgroundColor: theme.palette.action.hover,
  },
  // hide last border
  '&:last-child td, &:last-child th': {
    border: 0,
  },
}));

function createData(produit, commande, client) {
  return { produit, commande, client };
}

const rows = [
  createData('Frozen yoghurt', 159, 'Rabe'),
  createData('Ice cream sandwich', 237, 'Rasoa'),
  createData('Eclair', 262, 'Raly'),
  createData('Cupcake', 305, 'Koto'),
  createData('Gingerbread', 356,'Toto'),
];
const getMonthInterval = () => {
  const currentDate = new Date();
  const debDate = new Date(currentDate.getFullYear(), currentDate.getMonth() - 1, currentDate.getDate());
  const finDate = new Date(currentDate.getFullYear(), currentDate.getMonth(), currentDate.getDate());
  return { debDate, finDate };
};

const getWeekInterval = () => {
  const currentDate = new Date();
  const debDate = new Date(currentDate);
  debDate.setDate(currentDate.getDate() - 6);
  const finDate = new Date(currentDate);
  return { debDate, finDate };
};

const getYearInterval = () => {
  const currentDate = new Date();
  const debDate = new Date(currentDate.getFullYear() - 1, currentDate.getMonth(), currentDate.getDate());
  const finDate = new Date(currentDate.getFullYear(), currentDate.getMonth(), currentDate.getDate());
  return { debDate, finDate };
};

/*const barButtonClick = (periode) => {
  let intervalle;
  switch (periode) {
    case 'semaine':
      intervalle = getWeekInterval();
      break;
    case 'mois':
      intervalle = getMonthInterval();
      break;
    case 'an':
      intervalle = getYearInterval();
      break;
    default:
      intervalle = getMonthInterval();
      break;
  }
  console.log(`debut ${periode}:`, intervalle.debDate);
  console.log(`fin ${periode}:`, intervalle.finDate);
};*/

const Dashboard = () => {
  const [dataRev, setDataRev] = useState([]);
  const [totRevenue,setTotRevenue]=useState(0);
  const [nbCli,setNbCli]=useState(0);
  const [nbCmd,setNbCmd]=useState(0);
  const [dataCmd, setDataCmd] = useState([]);
  const fournisseurId = localStorage.getItem('fournisseurId');
  const [anchorElNav, setAnchorElNav] = useState(null);
  const [anchorElUser, setAnchorElUser] = useState(null);
  const [fournisseur, setFournisseur] = useState(null); // State to hold fournisseur details
  const [companyName, setCompanyName] = useState('');
  const [debutDate, setDebutDate] = useState(getMonthInterval().debDate);
  const [endDate, setEndDate] = useState(getMonthInterval().finDate);
  const [debutPieDate, setDebutPieDate] = useState(getMonthInterval().debDate);
  const [endPieDate, setEndPieDate] = useState(getMonthInterval().finDate);
  const [revenueData, setRevenueData] = useState({ dates: [], montants: [] });
  const [achats, setAchats] = useState([]);

  const barButtonClick = (periode) => {
    let intervalle;
    switch (periode) {
        case 'semaine':
            intervalle = getWeekInterval();
            break;
        case 'mois':
            intervalle = getMonthInterval();
            break;
        case 'an':
            intervalle = getYearInterval();
            break;
        default:
            intervalle = getMonthInterval();
            break;
    }
    setDebutDate(intervalle.debDate);
    setEndDate(intervalle.finDate);
};

const pieButtonClick = (periode) => {
  let intervalle;
  switch (periode) {
    case 'semaine':
      intervalle = getWeekInterval();
      break;
    case 'mois':
      intervalle = getMonthInterval();
      break;
    case 'an':
      intervalle = getYearInterval();
      break;
    default:
      intervalle = getMonthInterval();
      break;
  }
  console.log(`debut ${periode}:`, intervalle.debDate);
  console.log(`fin ${periode}:`, intervalle.finDate);
  setDebutPieDate(intervalle.debDate);
  setEndPieDate(intervalle.finDate);
};


  useEffect(() => {

  /*******************GET LISTE COMMANDE CES DERNIERS 30JOURS */
    const fetchAchats = async () => {
      if (fournisseurId) {
      try {
        const response = await axios.get(`http://localhost:8092/achat/listAchat/${fournisseurId}/last30days`);
        if (Array.isArray(response.data)) {
          setAchats(response.data);
      } else {
          console.error('Expected an array but got:', response.data);
          setAchats([]); // Reset to empty array if not an array
      }
         console.log('Response liste des achats ces 30 derniers jours:', response.data);
      } catch (error) {
        console.error('Error fetching achats:', error);
      }
    }
    };

    fetchAchats();
  }, [fournisseurId]);

/********** GET REVENUE PAR DATE*********************** */
const fetchRevenueData = async () => {
  if (fournisseurId) {
      try {
          const response = await axios.get(`http://localhost:8092/achat/revenueFr/${fournisseurId}`, {
              params: {
                  debutDate: debutDate.toISOString().split('T')[0],
                  endDate: endDate.toISOString().split('T')[0]
              }
          });
          const data = response.data;
          const formattedDates = data.map((d) => {
            const date = new Date(d.date);
            const options = { month: 'short', day: 'numeric' };
            return date.toLocaleDateString('en-US', options).replace(' ', '-');
          });
          const montants = data.map((d) => d.totalRevenue);
          setRevenueData({ dates: formattedDates, montants });
          console.log('Resultats de revenueData:', { dates: formattedDates, montants });
      } catch (error) {
          console.error('Error fetching revenue data:', error);
      }
  }
};

React.useEffect(() => {
  fetchRevenueData();
}, [debutDate, endDate, fournisseurId]);

/********** GET TOP 5 PRODUITS *************** */
  useEffect(() => {
    const fetchTop5Data = async () => {
      if (fournisseurId) {
      try {
        const response = await axios.get(`http://localhost:8092/achat/top5produits/${fournisseurId}`, {
          params: {
              debutDate: debutPieDate.toISOString().split('T')[0],
              endDate: endPieDate.toISOString().split('T')[0]
          }
      });
        setDataRev(response.data);
        console.log("retour sur la récupération :", response.data);
      } catch (error) {
        console.error('Error fetching top 5 produits:', error);
      }
    }
    };

    fetchTop5Data();
  }, [fournisseurId]);

/*

  /********** GET TOP 5 PRODUITS *************** 
  useEffect(() => {
    const fetchTop5Data = async () => {
      if (fournisseurId) {
      try {
        const response = await axios.get(`http://localhost:8092/achat/top5produits/${fournisseurId}`); // Replace idFr with the actual fournisseur ID
        setDataRev(response.data);
        console.log("retour sur la récupération :", response.data);
      } catch (error) {
        console.error('Error fetching top 5 produits:', error);
      }
    }
    };

    fetchTop5Data();
  }, [fournisseurId]);*/

  // Prepare data for the doughnut chart


  // ****************** DATA A AFFICHER DANS DOUGHNUTCHART *********************************************
  const chartData = dataRev.map(item => ({
    label: item[0],
    value: item[1], // Total quantity sold
  }));
  
  

  /************* GET TOTAL REVENUE DE CES DERNIERS 30JOURS ************************ */
  useEffect(() => {
    const fetchTotalRevenue = async () => {
      if(fournisseurId){
      try {
        const response = await axios.get(`http://localhost:8092/achat/revenueMoisFr/${fournisseurId}`); // Replace idFr with the actual fournisseur ID
        setTotRevenue(response.data);
        console.log("retour sur la récupération DU TOT revenue :", response.data);

        
      } catch (error) {
        console.error('Error fetching revenue produits:', error);
      }
      }
      
    };

    fetchTotalRevenue();
  }, [fournisseurId]);

   /************* GET TOTAL COMMANDE DE CES DERNIERS 30JOURS ************************ */
   useEffect(() => {
    const fetchNbCommande = async () => {
      if(fournisseurId){
      try {
        const response = await axios.get(`http://localhost:8092/achat/fournisseur/${fournisseurId}/nbAchat/last30days`); // Replace idFr with the actual fournisseur ID
        setNbCmd(response.data);
        console.log("retour sur la récupération DU TOT commande:", response.data);

        
      } catch (error) {
        console.error('Error fetching commande produits:', error);
      }
      }
      
    };

    fetchNbCommande();
  }, [fournisseurId]);

  /************* GET NOMBRE DE CLIENTS DE CES DERNIERS 30JOURS ************************ */
  useEffect(() => {
    const fetchNbClient = async () => {
      if(fournisseurId){
      try {
        const response = await axios.get(`http://localhost:8092/achat/fournisseur/${fournisseurId}/nbCli/last30days`); // Replace idFr with the actual fournisseur ID
        setNbCli(response.data);
        console.log("retour sur la récupération DU NB client:", response.data);

        
      } catch (error) {
        console.error('Error fetching nombre client:', error);
      }
      }
      
    };

    fetchNbClient();
  }, [fournisseurId]);
  const fetchCompanyName = async () => {
    const fournisseurId = localStorage.getItem('fournisseurId');
    if (fournisseurId) {
      try {
        const response = await axios.get(`http://localhost:8092/auth/detailFr/${fournisseurId}`);
        setCompanyName(response.data.company); 
        setFournisseur(response.data);
      } catch (error) {
        console.error('Error fetching company name:', error);
      }
    }
  };
  React.useEffect(() => {

    fetchCompanyName(); 
  }, []); 
  const handleOpenNavMenu = (event) => {
    setAnchorElNav(event.currentTarget);
  };
  const handleOpenUserMenu = (event) => {
    setAnchorElUser(event.currentTarget);
  };

  const handleCloseNavMenu = () => {
    setAnchorElNav(null);
  };

  const handleCloseUserMenu = () => {
    setAnchorElUser(null);
  };

  const handleLogout = async () => {
   try{
    await axios.post('http://localhost:8092/auth/logout');
    console.log("logout reussie");
    window.location.href='/';
   }
   catch(error){
      console.error('logout echec',error);
   }
    
  };



  return (
    <>
     <AppBar position="fixed" sx={{backgroundColor:'white'}}>
      <Toolbar>
      <Container maxWidth="xl">
        <Toolbar disableGutters>
        <Box style={{ display: 'flex', justifyContent: 'center', alignItems: 'center',marginRight:'20px'}}>
  <img src="/logo.png" alt="Tsena" width="50px" />
  <img src="/logotsena.png" alt="Tsena" width="50px" />
  </Box>

          <Box sx={{ flexGrow: 1, display: { xs: 'flex', md: 'none' } }}>
            <IconButton
              size="large"
              aria-label="account of current user"
              aria-controls="menu-appbar"
              aria-haspopup="true"
              onClick={handleOpenNavMenu}
              color="orange"
            >
              <MenuIcon />
            </IconButton>
            <Menu
              id="menu-appbar"
              anchorEl={anchorElNav}
              anchorOrigin={{
                vertical: 'bottom',
                horizontal: 'left',
              }}
              keepMounted
              transformOrigin={{
                vertical: 'top',
                horizontal: 'left',
              }}
              open={Boolean(anchorElNav)}
              onClose={handleCloseNavMenu}
              sx={{
                display: { xs: 'block', md: 'none' },
              }}
            >
              
                <MenuItem  onClick={handleCloseNavMenu}>
                <Link to="/fournisseur" sx={{my: 2, color: 'orange', display: 'block'}}>Produits</Link> 
                </MenuItem>
                <MenuItem  onClick={handleCloseNavMenu}>
                <Link to="/dashboard-fournisseur" sx={{textDecoration:'none', color:'orange'}}>Dashboard</Link>
                </MenuItem>
              
            </Menu>
          </Box>
        
          <Box sx={{ flexGrow:1, display: { xs: 'none', md: 'flex' }, width:{md:'30%',marginRight:'10px'} }}>
            {/* Link to fournisseur page onClick={handleCloseNavMenu}*/}
            <Button
              
              sx={{ my: 2, color: '#f3c0cc', display: 'block'}}
            >
              <Link to="/fournisseur" sx={{my: 2, color: 'orange', display: 'block'}}>Produits</Link> 
           </Button>
            
            {/* Link to dashboard page */}
            <Button
              onClick={handleCloseNavMenu}
              sx={{ my: 2, color: '#f3c0cc', display: 'block', textDecorationStyle:'none'}}
            >
              <Link to="/dashboard-fournisseur" sx={{textDecoration:'none', color:'orange'}}>Dashboard</Link> 
            </Button>
          </Box>
         

          
          {/* User Menu */}
          <Box sx={{ flexGrow: 0 }}>
              <Tooltip title={companyName}>
                <IconButton onClick={handleOpenUserMenu} sx={{ p: 0 }}>
                  <Avatar alt={companyName} src="/static/images/avatar/2.jpg" />
                </IconButton>
                 {/* Fournisseur company name */} 
              
              </Tooltip>
              <Menu
                sx={{ mt: '45px' }}
                id="user-menu-appbar"
                anchorEl={anchorElUser}
                anchorOrigin={{
                  vertical: 'top',
                  horizontal: 'right',
                }}
                keepMounted
                transformOrigin={{
                  vertical: 'top',
                  horizontal: 'right',
                }}
                open={Boolean(anchorElUser)}
                onClose={handleCloseUserMenu}
              >
                                {/* Profil */}
                  <MenuItem component={Link} to="/profil/fournisseur" onClick={handleCloseUserMenu}>
                    <PersonIcon sx={{ marginRight: 1 }} />
                    <Typography textAlign="center">Profil</Typography>
                  </MenuItem>

                  {/* Help */}
                  <MenuItem component={Link} to="/aide" onClick={handleCloseUserMenu}>
                    <HelpIcon sx={{ marginRight: 1 }} />
                    <Typography textAlign="center">Aide</Typography>
                  </MenuItem>

                  {/* Logout */}
                  <MenuItem onClick={handleLogout}>
                    <LogoutIcon sx={{ marginRight: 1 }} />
                    <Typography textAlign="center">Déconnexion</Typography>
                  </MenuItem>
              </Menu>
            </Box>
        </Toolbar>
      </Container>
      </Toolbar>
    </AppBar>
    
      <div className="englobeD">
        <Stack sx={{width:'28%'}}>
          <h4>Commande en cours</h4>
          <TableContainer component={Paper}>
            <Table sx={{ minWidth: 400 }} aria-label="customized table">
              <TableHead>
                <TableRow>
                  <StyledTableCell>Produit</StyledTableCell>
                  <StyledTableCell align="right">Commande</StyledTableCell>
                  <StyledTableCell align="right">Nom du Client</StyledTableCell>
                </TableRow>
              </TableHead>
              <TableBody>
          {achats.length === 0 ? (
            <TableRow>
              <TableCell colSpan={5} align="center">Aucun achat au cours des 30 derniers jours</TableCell>
            </TableRow>
          ) : (
            achats.map((achat) => (
              <StyledTableRow key={achat.id}>
                <StyledTableCell component="th" scope="row">
                  {achat.achatPro.designation}
                </StyledTableCell>
                <StyledTableCell align="right">{achat.achatPro.design}</StyledTableCell>
                <StyledTableCell align="right">{achat.achatCli ? achat.achatCli.pseudo : 'Anonyme'}</StyledTableCell>
                <StyledTableCell align="right">{achat.qteAchat}</StyledTableCell>
                <StyledTableCell align="right">{new Date(achat.dateAchat).toLocaleDateString()}</StyledTableCell>
              </StyledTableRow>
            ))
          )}
        </TableBody>
            </Table>
          </TableContainer>
        </Stack>
       
        <div className="dashdroit">
        <h3>Dashboard</h3>
        <Container sx={{marginTop:'20px'}}>
            <Box sx={{ display: 'flex', flexWrap: 'wrap', justifyContent: 'space-between',marginLeft:'-70px' }}> 
              <CardStatistic icon={AnalyticsIcon} // Use MUI BookingSharp icon
                title="Vos Clients"
                value={nbCli}
                textSub="Ces derniers 30 jours"
                boxColor="#d2486af0" />
                <CardStatistic icon={AnalyticsIcon} // Use MUI BookingSharp icon
                title="Commande"
                value={nbCmd}
                textSub="Ces derniers 30 jours"
                boxColor="#F44336" />
              <CardStatistic icon={MoneySharp} // Use MUI MoneySharp icon
                title="Revenue"
                value={totRevenue}
                textSub="Ces derniers 30 jours"
                 boxColor="#fbc105" />
              {/* Add more CardStatistic components for other statistics */}
            </Box>
          </Container>
        <Container sx={{marginTop:'95px'}}>
        <Grid container spacing={3}>
          <Paper elevation={2} sx={{minWidth:'300px',width:'420px',alignItems:'center',position:'absolute',padding:'10px'}}>
          <div className='chartL'>
                  <LineChart
                    sx={(theme) => ({
                      
                      [`.${axisClasses.root}`]: {
                        [`.${axisClasses.tick}, .${axisClasses.line}`]: {
                          stroke: 'white',
                          strokeWidth: 1,
                        },
                        [`.${axisClasses.tickLabel}`]: {
                          fill: 'white',
                        },
                      },
                    })}
                    series={[{ data: revenueData.montants,color: 'white'}]}
                    width={400}
                    height={250}
                    
                    xAxis={[{ scaleType: 'point', data:revenueData.dates, area:true}]}
                    margin={{ left: 65, right: 40, top: 30, bottom: 30 }}
                    
                    
                  />
                </div>
      <p>Suivi des ventes</p>
      <p>Vous pouvez suivre ici les operations des ventes soit annuellement,mensuellement ou hebdomadaire</p>
    <Stack direction="row">
      <Button
            type="button"
            variant="outlined"
            fullWidth
            sx={{           
        borderRadius: 2,
        height: 30,
        margin:'5px',
        padding: '5px',
        
            }}
            onClick={() => barButtonClick('semaine')}  
          >
           Semaine
          </Button>
          <Button
            type="button"
            variant="outlined"
            fullWidth
            sx={{
             
        borderRadius: 2,
        height: 30,
        margin:'5px',
        padding: '5px',       
            }}
            onClick={() => barButtonClick('mois')}
          >
           Mois
          </Button>
          <Button
            type="button"
            variant="outlined"
            fullWidth
            sx={{
            
        borderRadius: 2,
        height: 30,
        padding: '5px',
        margin:'5px',
        
            }}
            onClick={() => barButtonClick('an')} 
          >
           Annee
          </Button>
          </Stack>
          </Paper>
          <Paper elevation={2} sx={{minWidth:'300px',width:'420px',padding:'10px',marginLeft:'480px'}}>
          <div className='chartP'>
          <PieChart
          colors ={palette}
          
        series={[
          {
          
            paddingAngle: 5,
            innerRadius: 60,
            outerRadius: 80,
            data: chartData,
            
          },
        ]}
        
        width={400}
        height={250}
        margin={{ left: 0, right: 170, top: 30, bottom: 30 }}
        legend={{ hidden: false }}
      /></div>
      <p>Suivi des achats</p>
      <p>Visualisez ici vos 5 produits les plus populaires soit annuellement,mensuellement ou hebdomadaire</p>
      <Stack direction="row">
      <Button
            type="button"
            variant="outlined"
            fullWidth
            sx={{           
        borderRadius: 2,
        height: 30,
        margin:'5px',
        padding: '5px',   
        
            }}
            onClick={() => pieButtonClick('semaine')}   
          >
           Semaine
          </Button>
          <Button
            type="button"
            variant="outlined"
            fullWidth
            sx={{
             
        borderRadius: 2,
        height: 30,
        margin:'5px',
        padding: '5px',
            }}
            onClick={() => pieButtonClick('mois')}   
          >
          Mois
          </Button>
          <Button
            type="button"
            variant="outlined"
            fullWidth
            sx={{
            
        borderRadius: 2,
        height: 30,
        padding: '5px',
        margin:'5px',
            }}
            onClick={() => pieButtonClick('an')}   
          >
          Annee
          </Button>
          </Stack>
          
          </Paper>
          
          </Grid>

        </Container>
        </div>
      
      
      </div>
    

    </>
  );
}

export default Dashboard;
/*
   leftAxis={{
                      
                      tickLabelStyle: {
                
                        fontSize: 10,
                        stroke: 'white', 
                      },
                      tickSize: 3,
                    }}
                    bottomAxis={{
                      disableLine: true,
                      tickLabelStyle: {
                        angle: 45,
                        textAnchor: 'middle',
                        fontSize: 10,
                        stroke: 'white', 
                      },
                      tickSize: 3,
                    }}

                    const xAxisStyle = {
    labelStyle: {
      color: 'white', // Set x-axis label color to white
    },
    stroke: 'white', // Set x-axis line color to white
  };
 */