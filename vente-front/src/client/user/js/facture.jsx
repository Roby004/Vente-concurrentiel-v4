import React, { useState, useEffect } from 'react'
import '../css/facture.css'
import logo from './logo.png'
import titre from './titre.png'
import { Typography } from '@mui/material'

export default function Facture({ data, client }) {
    const [cli, setCli] = useState({})
    const total = data.reduce((acc, item) => {
        return acc + (item.prix * item.count)
    }, 0)

    
    const date = new Date()
    const y = date.getFullYear()
    const m = String(date.getMonth() + 1).padStart(2, '0')
    const d = String(date.getDate()).padStart(2, '0')
    const today = `${y}-${m}-${d}`

    useEffect(() => {
        client.map(item => {
            setCli({...item})
        })
    }, [client])
    // console.log(cli)
    return (
        <>
            <div id='facture-body'>
                <div id='facture-header'>
                    {/* <div id='facture-logo' style={{ marginRight: 'auto', marginLeft: '30px', display: 'flex', alignItems: 'center', justifyContent: 'start' }}>
                        <img src={logo} alt="logo" width={'35px'} height={'40px'} />
                        <img src={titre} alt="titre" width={'80px'} height={'40px'} style={{ marginLeft: '5px' }} />
                    </div> */}
                    <Typography sx={{ fontSize: 35, fontWeight: '700', color: 'rgb(38 38 38)', margin: 'auto' }}>FACTURE</Typography>
                </div>

                <div id='facture-detail'>
                    <div>
                        <Typography sx={{ fontSize: 18, fontWeight: '600', color: 'rgb(38 38 38)' }}>Client : </Typography>
                        <Typography sx={{ fontSize: 18, fontWeight: '500', color: 'rgb(38 38 38)' }}> {cli.pseudo} </Typography>
                    </div>
                    <div>
                        <Typography sx={{ fontSize: 18, fontWeight: '600', color: 'rgb(38 38 38)' }}>Contact : </Typography>
                        <Typography sx={{ fontSize: 18, fontWeight: '500', color: 'rgb(38 38 38)' }}> {cli.contact}</Typography>
                    </div>
                    <div>
                        <Typography sx={{ fontSize: 18, fontWeight: '600', color: 'rgb(38 38 38)' }}>Adresse : </Typography>
                        <Typography sx={{ fontSize: 18, fontWeight: '500', color: 'rgb(38 38 38)' }}> {cli.adresse}</Typography>
                    </div>
                    <div>
                        <Typography sx={{ fontSize: 18, fontWeight: '600', color: 'rgb(38 38 38)' }}>Date : </Typography>
                        <Typography sx={{ fontSize: 18, fontWeight: '500', color: 'rgb(38 38 38)' }}> {today}</Typography>
                    </div>

                </div>

                <div id='facture-tableau'>
                    <table>
                        <thead>
                            <tr>
                                <th>
                                    <Typography sx={{ fontSize: 18, fontWeight: '600', color: 'rgb(38 38 38)' }}>Désignation</Typography>
                                </th>
                                <th>
                                    <Typography sx={{ fontSize: 18, fontWeight: '600', color: 'rgb(38 38 38)' }}>Quantité</Typography>
                                </th>
                                <th>
                                    <Typography sx={{ fontSize: 18, fontWeight: '600', color: 'rgb(38 38 38)' }}>Prix unitaire</Typography>
                                </th>
                                <th>
                                    <Typography sx={{ fontSize: 18, fontWeight: '600', color: 'rgb(38 38 38)' }}>Prix total</Typography>
                                </th>
                            </tr>
                        </thead>

                        <tbody>
                            {data.map((item, index) => {
                                return (
                                    <tr key={index}>
                                        <td>
                                            <Typography sx={{ fontSize: 18, fontWeight: '500', color: 'rgb(38 38 38)' }}>{item.design}</Typography>
                                        </td>
                                        <td>
                                            <Typography sx={{ fontSize: 18, fontWeight: '500', color: 'rgb(38 38 38)' }}>{item.count}</Typography>
                                        </td>
                                        <td>
                                            <Typography sx={{ fontSize: 18, fontWeight: '500', color: 'rgb(38 38 38)' }}>{item.prix}</Typography>
                                        </td>
                                        <td>
                                            <Typography sx={{ fontSize: 18, fontWeight: '500', color: 'rgb(38 38 38)' }}>{item.count * item.prix}</Typography>
                                        </td>
                                    </tr>
                                )
                            })}
                        </tbody>
                    </table>

                    <div id='facture-footer'>
                        <Typography sx={{ fontSize: 18, fontWeight: '500', color: 'rgb(38 38 38)', marginRight: '7px' }}>Total : </Typography>
                        <Typography sx={{ fontSize: 22, fontWeight: '600', color: 'rgb(38 38 38)' }}> Ar {total} </Typography>
                    </div>

                </div>
            </div>
        </>
    )
}