import { React, useEffect, useState } from 'react'
import "./dashboard.css"
import "./exemple.css"
import { Link } from 'react-router-dom'
import logo from './image/logo2.png'
import titre from './image/titre2.png'
import V17 from './voiture/V17.png'
import pdp from './image/pdp.jpg'
import Modals from '../modal/modal'
import Snackbars from '../modal/snackbar'

import { PieChart } from '@mui/x-charts/PieChart'
import { LineChart } from '@mui/x-charts/LineChart'

import { Delete, PersonOutlined, WidgetsOutlined, FactoryOutlined, Logout, LeaderboardOutlined, ShoppingBagOutlined, ChevronRight, ChevronLeft, Cancel, CheckCircle, } from '@mui/icons-material'

import { styled } from '@mui/material/styles'
import { IconButton, Avatar, Button } from '@mui/material'
import { Typography, FormControl, Select, Menu, MenuItem } from '@mui/material'
import axios from 'axios'

const url = 'http://localhost:8080/'

const StyledSelect = styled(Select)(({ theme }) => ({
    '& .MuiSelect-select': {
        backgroundColor: 'transparent',
        // borderColor: 'white',
        borderRadius: '10px',
        // outline: 'white',
        height: '10px',
        color: 'rgb(115 115 115)',
        fontSize: '0.85rem',
        width: '100%',
        '&:focus': {
            borderColor: '#ff7f00',
            outline: '#ff7f00'
        },
    },
}))

export default function AdminDashboard() {
    const [pro, setPro] = useState([])  // -------------- Décommenter
    const [rows, setRows] = useState([])
    const [revenu, setRevenu] = useState([]) 
    const [page, setPage] = useState(1)
    const [triCat, setTriCat] = useState('cuisine')
    const [triAnnee, setTriAnnee] = useState(2024)
    const [modal, setModal] = useState(false)
    const [success, setSuccess] = useState(false)
    const [error, setError] = useState(false)
    const [id, setId] = useState(null)
    const [produit, setProduit] = useState([])
    const [achat, setAchat] = useState([])
    const [count, setCount] = useState({ client: 0, fourni: 0, achat: 0, produit: 0 })

    // ----------- fafana -------------
    // const data = [
    //     { label: 'Group A', value: 2400 },
    //     { label: 'Group B', value: 4567 },
    //     { label: 'Group C', value: 1398 },
    //     { label: 'Group D', value: 9800 },
    //     { label: 'Group E', value: 3908 },
    //     { label: 'Group F', value: 4800 },
    // ]

    // const rows = [
    //     { idPro: 1, design: 'Audi V08-A55', nomFr: 'Audi', idFr: 1, imgPro: V17 },
    //     { idPro: 2, design: 'Velo V08-A57', nomFr: 'Velo', idFr: 2, imgPro: V17 },
    //     { idPro: 3, design: 'BMW V14-B55', nomFr: 'BMW', idFr: 3, imgPro: V17 },
    //     { idPro: 4, design: 'Samsung Galaxy', nomFr: 'Samsung', idFr: 4, imgPro: V17 },
    //     { idPro: 5, design: 'Table 16*16', nomFr: 'Table', idFr: 5, imgPro: V17 },
    //     { idPro: 6, design: 'Cable USB', nomFr: 'MSV', idFr: 6, imgPro: V17 },
    //     { idPro: 7, design: 'Cable ', nomFr: 'MSV', idFr: 6, imgPro: V17 },
    //     { idPro: 8, design: 'Cable', nomFr: 'MSV', idFr: 6, imgPro: V17 },
    //     { idPro: 9, design: 'Cable USB', nomFr: 'MSV', idFr: 6, imgPro: V17 },
    //     { idPro: 10, design: 'Cable USB', nomFr: 'MSV', idFr: 6, imgPro: V17 },
    // ]

    // const categ = ['Voiture', 'Meuble', 'Chaussure', 'Téléphone']
    // const selectAnnee = ['2021', '2022', '2023', '2024']

    // --------------------------------

    const pieParams = { height: 230, width: 400, margin: { right: 150,  } }

    // --------- Pagination -----------
    const elemPage = 7
    const totalPage = Math.ceil(rows.length / elemPage)
    const start = (page - 1) * elemPage
    const end = start + elemPage
    const dataPage = rows.slice(start, end)

    const nextPage = () => {
        setPage(prevPage => Math.min(prevPage + 1, totalPage))
    }

    const prevPage = () => {
        setPage(prevPage => Math.max(prevPage - 1, 1))
    }

    const handleChangeSelect1 = (event) => {
        setTriAnnee(event.target.value)
    }
    const handleChangeSelect2 = (event) => {
        setTriCat(event.target.value)
    }

    // ----------- Logique pour get les produits à effacer ------------------
    useEffect(()=> {
        axios.get('http://localhost:8080/produit/produitsDashboard').then(function (response) {
            setRows(response.data)
        }, function (error) {
            console.log(error)
        })
    }, [rows])


    // ------------ Logique pour retirer les produits ------------------
    const deletePro = (id) => {
        setId(id)
        setModal(true)
    }

    const deleteProBdd = () => {
        axios.delete('http://localhost:8080/produit/' + `produitsDelete/${id}`).then(function (response) {
            setId(null)
            setSuccess(true)
            setTimeout(() => {
                setSuccess(false)
            }, 5000)
        }, function (error) {
            setError(true)
            setTimeout(() => {
                setError(false)
            }, 5000)
            console.log(error)
        })
    }

    // ---------- décommenter -------------------
    useEffect(() => {
        axios.get(url + 'produit/produits').then(function (response) {
             setProduit(response.data)
        }, function (error) {
            console.log(error)
        })
    }, [produit])

    useEffect(() => {
        axios.get(url + 'achat/achatDashboard').then(function (response) {
            setAchat(response.data)
        }, function (error) {
            console.log(error)
        })
    }, [achat])

    const categ = [...new Set(produit.map(obj => obj.categorie))]
    
    const selectAnnee = [...new Set(achat.map(obj => {
        const date = new Date(obj.dateAchat)
        const y = date.getFullYear()
        return y
    }))]

    // -------------- Logique pour récupérer les 6 produits les plus vendus par catégorie avec leur nombre -------------
    useEffect(() => {
        axios.get(url+`produit/produitsGraphe/${triCat}`).then(function (response) {
            setPro(response.data)
            // console.log('graphe donut bdd: ', response.data)
        }, function (error) {
            console.log(error)
        })
    }, [pro, triCat])

    const data = [...new Set(pro.map(item => {
         return { label: item.label, value: item.value}
    }))]

    // console.log('donut: ', data)

    // -------------- Logique pour les revenus des 6 derniers mois -----------------
    useEffect(() => {
        axios.get(url+`produit/produitRevenue/${triAnnee}`).then(function (response) {
            setRevenu(response.data)
            // console.log('revenu bdd : ', response.data)
        }, function (error) {
            console.log(error)
        })
    }, [revenu, triAnnee])

    const revenuPrix = [...new Set( revenu.map(item => {return item.revenue}) )]
    // console.log('revenu: ', revenuPrix)

    // -------------- Logique pour les nb de clients -----------------
    useEffect(() => {
        axios.get('http://localhost:8080/client/clientsNb').then(function (response) {
            setCount({...count, client: response.data})
        }, function (error) {
            console.log(error)
        })
    }, [])

    // -------------- Logique pour les nb de fournisseurs -----------------
    useEffect(() => {
        axios.get('http://localhost:8080/fournisseur/fournisseursNb').then(function (response) {
            setCount({...count, fourni: response.data})
        }, function (error) {
            console.log(error)
        })
    }, [])


    return (
        <>
            <div id='admin-body'>
                <div id='admin-left'>
                    <div id='admin-menu'>
                        <div id='admin-logo'>
                            <div id='logo-container'>
                                <img src={logo} alt="logo" />
                                <img src={titre} alt="titre" />
                            </div>
                        </div>

                        <div id='menu-container'>
                            <Link id='link' to='/admin/client'>
                                <div id='menu-button'>
                                    <PersonOutlined id='menu-icon' sx={{ fontSize: 25, margin: 'auto' }} />
                                    <Typography id='menu-titre' sx={{ fontSize: 17, fontWeight: '500', }}>Client</Typography>
                                </div>
                            </Link>

                            <Link id='link' to='/admin/fournisseur'>
                                <div id='menu-button'>
                                    <FactoryOutlined id='menu-icon' sx={{ fontSize: 25, margin: 'auto' }} />
                                    <Typography id='menu-titre' sx={{ fontSize: 17, fontWeight: '500', }}>Fournisseur</Typography>
                                </div>
                            </Link>

                            <Link id='link' to='/admin/produit'>
                                <div id='menu-button'>
                                    <WidgetsOutlined id='menu-icon' sx={{ fontSize: 25, margin: 'auto' }} />
                                    <Typography id='menu-titre' sx={{ fontSize: 17, fontWeight: '500', }}>Produit</Typography>
                                </div>
                            </Link>

                            <Link id='link' to='/admin/achat'>
                                <div id='menu-button'>
                                    <ShoppingBagOutlined id='menu-icon' sx={{ fontSize: 25, margin: 'auto' }} />
                                    <Typography id='menu-titre' sx={{ fontSize: 17, fontWeight: '500', }}>Achat</Typography>
                                </div>
                            </Link>

                            <Link id='link' to='/admin/dashboard'>
                                <div id='menu-button' className='active' style={{ borderBottom: '2p x solid rgb (238, 238, 238)' }}>
                                    <LeaderboardOutlined id='menu-icon' sx={{ fontSize: 25, margin: 'auto' }} />
                                    <Typography id='menu-titre' sx={{ fontSize: 17, fontWeight: '500', }}>Dashboard</Typography>
                                </div>
                            </Link>
                        </div>

                        <div id='admin-logout'>
                            <div id='menu-button' style={{ borderBottom: '2p x solid rgb (238, 238, 238)' }}>
                                <Logout id='menu-icon' sx={{ fontSize: 25, margin: 'auto' }} />
                                <Typography id='menu-titre' sx={{ fontSize: 17, fontWeight: '500', }}>Se déconnecter</Typography>
                            </div>
                        </div>
                    </div>

                </div>

                <div id='admin-right'>
                    <div id='admin-header'>
                        <Typography sx={{ fontSize: 25, fontWeight: '500', color: 'rgb(100 100 100)', marginLeft: '2%', }}>Dashboard</Typography>

                        <div id='container-search'>
                            {/* <div style={{ background: 'rgb(245 245 245)', height: '60%', borderRadius: '999px', padding: '2px 0px', display: 'flex', alignItems: 'center', width: "100%" }}>
                                <InputBase
                                    sx={{ ml: 1, flex: 1 }}
                                    placeholder="Rechercher des clients"
                                    inputProps={{ 'aria-label': 'recherche' }}
                                />
                                <IconButton type="button" sx={{ p: '10px', background: 'linear-gradient( #ed2645 ,#ff394b , #ff7f00 , #ffd400 )' }} aria-label="recherche">
                                    <Search sx={{ color: "white" }} />
                                </IconButton>
                            </div> */}
                        </div>

                        <IconButton sx={{ p: 0, ml: 2 }}>
                            <Avatar src={pdp} />
                        </IconButton>
                    </div>

                    <div id='admin-container-dash'>
                        <div id='admin-count'>

                            <div id='top-btn'>
                                <Link to="admin/client" id='link'>
                                    <div id='button-menu' className='activatedClient'>
                                        <PersonOutlined sx={{ fontSize: 50, color: '#ffd400', marginLeft: '20%' }} />
                                        <div style={{ float: 'right' }}>
                                            <Typography sx={{ fontSize: 16, fontWeight: '500', color: 'rgb(100 100 100)', marginLeft: '2%', }}>Clients</Typography>
                                            <Typography sx={{ fontSize: 22, fontWeight: '500', color: '#ffd400', marginLeft: '2%', }}>{count.client}</Typography>
                                        </div>
                                    </div>
                                </Link>

                                <Link to="admin/fournisseur" id='link'>
                                    <div id='button-menu' className='activatedFournisseur'>
                                        <FactoryOutlined sx={{ fontSize: 45, color: '#ed2645', marginLeft: '20%' }} />
                                        <div>
                                            <Typography sx={{ fontSize: 16, fontWeight: '500', color: 'rgb(100 100 100)', marginLeft: '2%', }}>Fournisseurs</Typography>
                                            <Typography sx={{ fontSize: 22, fontWeight: '500', color: '#ed2645', marginLeft: '2%', }}>{count.fourni ?? 0}</Typography>
                                        </div>
                                    </div>
                                </Link>

                                <Link to="admin/produit" id='link'>
                                    <div id='button-menu' className='activatedProduit'>
                                        <WidgetsOutlined sx={{ fontSize: 45, color: '#ff7f00', marginLeft: '20%' }} />
                                        <div>
                                            <Typography sx={{ fontSize: 16, fontWeight: '500', color: 'rgb(100 100 100)', marginLeft: '2%', }}>Produits</Typography>
                                            <Typography sx={{ fontSize: 22, fontWeight: '500', color: '#ff7f00', marginLeft: '2%', }}>{produit.length}</Typography>
                                        </div>
                                    </div>
                                </Link>

                                <Link to="admin/achat" id='link'>
                                    <div id='button-menu' className='activatedDashboard'>
                                        <ShoppingBagOutlined sx={{ fontSize: 45, color: '#8311ed', marginLeft: '20%' }} />
                                        <div>
                                            <Typography sx={{ fontSize: 16, fontWeight: '500', color: 'rgb(100 100 100)', marginLeft: '2%', }}>Achat</Typography>
                                            <Typography sx={{ fontSize: 22, fontWeight: '500', color: '#8311ed', marginLeft: '2%', }}>{achat.length}</Typography>
                                        </div>
                                    </div>
                                </Link>
                            </div>
                        </div>

                        <div id='admin-bottom'> {/*, transform: 'translate(-50%)' */}
                            <div id='admin-liste'>
                                <table id='liste-pro'>
                                    <thead>
                                        <tr>
                                            <th>
                                                <Typography sx={{ fontSize: 15, fontWeight: '500', color: 'rgb(38 38 38)' }}>Image</Typography>
                                            </th>
                                            <th>
                                                <Typography sx={{ fontSize: 15, fontWeight: '500', color: 'rgb(38 38 38)' }}>Produit</Typography>
                                            </th>
                                            <th>
                                                <Typography sx={{ fontSize: 15, fontWeight: '500', color: 'rgb(38 38 38)' }}>Fournisseur</Typography>
                                            </th>
                                            <th>
                                                <Typography sx={{ fontSize: 15, fontWeight: '500', color: 'rgb(38 38 38)' }}>Retiter</Typography>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {dataPage.map((item) => {
                                            const imageUrl=`data:image/png;base64,${item.imgPro}`
                                            return (
                                                <tr key={item.idPro}>
                                                    <td><Avatar sx={{ margin: 'auto'}} src={imageUrl} alt={item.design} width={'70px'} height={'40px'}></Avatar></td>
                                                    <td>
                                                        <Typography sx={{ fontSize: 15, fontWeight: '500', color: 'rgb(38 38 38)' }}>{item.design}</Typography>
                                                    </td>
                                                    <td>
                                                        <Typography sx={{ fontSize: 15, fontWeight: '500', color: 'rgb(38 38 38)' }}>{item.nomFr}</Typography>
                                                    </td>
                                                    <td>
                                                        <IconButton onClick={() => deletePro(item.idPro)}>
                                                            <Delete sx={{ '&:hover': { color: '#ed1111' } }} />
                                                        </IconButton>
                                                    </td>
                                                </tr>
                                            )
                                        })}
                                    </tbody>
                                </table>

                                <div style={{ width: 'fit-content', marginLeft: 'auto', height: '100%' }}>
                                    <IconButton onClick={prevPage} type="button" sx={{ visibility: (totalPage > 1 && page === totalPage) ? 'visible' : 'hidden', p: '1', width: 'fit-content', backgroundColor: 'rgba(128,128,128,0.15)' }} aria-label="prev">
                                        <ChevronLeft sx={{ color: "rgb(38 38 38)" }} />
                                    </IconButton>

                                    <IconButton onClick={nextPage} type="button" sx={{ visibility: (totalPage > 1 && page === 1) ? 'visible' : 'hidden', p: '1', width: 'fit-content', backgroundColor: 'rgba(128,128,128,0.15)' }} aria-label="next">
                                        <ChevronRight sx={{ color: "rgb(38 38 38)" }} />
                                    </IconButton>

                                </div>
                            </div>
                            <div id='admin-graphe'>
                                <div style={{ width: '90%', position: 'relative', height: '95%', borderRadius: '10px', margin: 'auto', background: 'white', marginTop: '10px' }}>
                                    <Typography sx={{ fontSize: 17, position: 'absolute', top: 2, left: '20%', fontWeight: '500', color: 'rgb(110 110 110)' }}>Revenu par mois</Typography>
                                    <FormControl size="small" sx={{ m: 1, width: 'fit-content', height: '40px', float: 'right', position: 'absolute', top: '0', right: '5%' }}>
                                        <StyledSelect
                                            sx={{}}
                                            value={triAnnee}
                                            onChange={handleChangeSelect1}
                                            displayEmpty
                                            // label='Catégorie'
                                            inputProps={{ 'aria-label': 'sort' }}
                                            autoWidth
                                        >
                                            {selectAnnee.map((item, index) => {
                                                return (
                                                    <MenuItem key={index} value={item} >{item}</MenuItem>
                                                )
                                            })}
                                        </StyledSelect>
                                    </FormControl>

                                    <LineChart
                                        xAxis={[
                                            {
                                                scaleType: 'point',
                                                data: ['Jan', 'Fév', 'Mars', 'Avr', 'Mai', 'Juin', 'Juil', 'Aout', 'Sept', 'Oct', 'Nov', 'Dec'],
                                                colorMap: {
                                                    type: 'continuous',
                                                    min: 0,
                                                    max: 5000,
                                                    color: ['#c51c53c0', '#6b2cf5c0']
                                                }
                                            }
                                        ]}
                                        yAxis={[
                                            {
                                                colorMap: {
                                                    type: 'continuous',
                                                    min: 0,
                                                    max: 5000,
                                                    color: ['#6b2cf5c0', '#c51c53c0']
                                                }
                                            }
                                        ]}
                                        series={[
                                            {
                                                // data: [7000, 6000, 3500, 4000, 8000, 10000, 4000, 8000, 10000, 7000, 6000, 3500],
                                                data: revenuPrix,
                                                area: true
                                            },
                                        ]}
                                        width={550}
                                        height={250}
                                        sx={{ ml: 6 }}
                                    />
                                </div>

                                <div style={{ width: '90%', display: 'grid', gridTemplateColumns: '70%', position: 'relative', height: '95%', borderRadius: '10px', margin: 'auto', background: 'white', marginTop: '10px' }}>
                                <Typography sx={{ fontSize: 17, position: 'absolute', top: 2, left: '20%', fontWeight: '500', color: 'rgb(110 110 110)' }}>Produits les plus vendus</Typography>

                                    <PieChart
                                        series={[
                                            {
                                                data: data,
                                                innerRadius: 70,
                                                outerRadius: 93,
                                                paddingAngle: 3,
                                                cornerRadius: 2,
                                                startAngle: -180,
                                                endAngle: 180,
                                                highlightScope: { faded: 'global', highlighted: 'item' },
                                                faded: { innerRadius: 10, additionalRadius: -10, },
                                            },
                                        ]}
                                        {...pieParams}
                                        sx={{mt: 3, ml: 10}}
                                    />

                                    <FormControl size="small" sx={{ m: 1, width: 'fit-content', height: '40px', float: 'right', position: 'absolute', top: '0', right: '5%' }}>
                                        <StyledSelect
                                            sx={{}}
                                            value={triCat}
                                            onChange={handleChangeSelect2}
                                            displayEmpty
                                            // label='Catégorie'
                                            inputProps={{ 'aria-label': 'sort' }}
                                            autoWidth
                                        >
                                            {categ.map((item, index) => {
                                                return (
                                                    <MenuItem key={index} value={item} >{item}</MenuItem>
                                                )
                                            })}
                                        </StyledSelect>
                                    </FormControl>

                                </div>

                            </div>

                        </div>
                    </div>
                </div>
            </div>
            {modal && <Modals
                icon={<Cancel sx={{ color: '#ed1111', width: 60, height: 60 }} />}
                color={'#ed1111'}
                para1={`Voulez-vous vraiment retirer ce produit ?`}
                para2={'Cette action est irreversible. Les données de ce produit seront perdues'}
                button={'Valider'}
                close={() => setModal(false)}
                action={deleteProBdd}
            />}
            {success &&
                <Snackbars
                    icon={<CheckCircle fontSize="inherit" sx={{ color: '#24cf0e' }} />}
                    para={"Le produit a été supprimé avec succès"}
                    color={"#24cf0e"}
                />
            }
            {error &&
                <Snackbars
                    icon={<Cancel fontSize="inherit" sx={{ color: '#ed1111' }} />}
                    para={"un problème est survenu lors de la suppression"}
                    color={"#ed1111"}
                />
            }
        </>
    )
}