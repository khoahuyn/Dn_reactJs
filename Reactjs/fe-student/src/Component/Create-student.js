import React, {useEffect, useState} from "react";
import {ErrorMessage, Field, Form, Formik} from "formik";
import '../Css/create-student.css';
import anh from '../image/default-avatar.png';
import * as Yup from "yup";
import {save} from "../Service/studentService";
import {toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import * as gradeService from '../Service/gradeService'
import axios from "axios";
const URL = "http://localhost:8080/api/get-all-grade";
const URL2 = "http://localhost:8080/api/create-student";




export function Create() {
    const [grades, setGrades] = useState([])

    const [avatar,setAvatar]=useState(null)



    useEffect(() => {
        findAll();
    }, []);



    const findAll = async () => {
        try {
            const result = await gradeService.findAllGrade(URL);
            setGrades(result);
        } catch (error) {
            console.error("Error fetching grades:", error);
        }
    }


    function displayImage(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                document.getElementById('avatar-image').src = e.target.result;
            }

            reader.readAsDataURL(input.files[0]);
        }
        setAvatar({avatar:avatar})
    }







    return (
        <>
            <Formik
                initialValues=
                    {{
                        studentId: '',
                        name: '',
                        dateOfBirth: '',
                        address: '',
                        phone: '',
                        email: '',
                        avatar: null,
                        gender: false,
                        deleteFlag: '',
                        grade: 3,
                        account: ''
                    }}

                onSubmit={async (values) => {
                    try {
                        values.gender = values.gender === 'true' ? 0 : 1;
                        save(values);
                        toast('🦄 Add student successfully!!!!');
                    } catch (error) {
                        console.error('Error uploading file or saving student:', error);
                    }
                }}

                // onSubmit={async (values) => {
                //     try {
                //         // const formData = new FormData();
                //         //
                //         //
                //         // if (avatar) {
                //         //     formData.append('avatar', avatar);
                //         // }
                //         //
                //         // // Send the formData with all fields to the server
                //         // await axios.post(URL2, formData, {
                //         //     headers: {
                //         //         'Content-Type': 'multipart/form-data',
                //         //     },
                //         // });
                //
                //         values.gender = values.gender === 'true' ? 1 : 0;
                //         save(values);
                //
                //         toast('🦄 Add student successfully!!!!');
                //     } catch (error) {
                //         console.error('Error uploading file or saving student:', error);
                //     }
                // }}




                validationSchema={Yup.object({
                    name: Yup.string()
                        .required('Tên sinh viên không được để trống')
                        .min(5, 'Tên sinh viên không được bé hơn 5')
                        .max(50, 'Tên sinh viên không được lớn hơn 50')
                        .matches(/^[a-zA-Z\s]+$/, "Tên sinh viên không được chứa ký tự đặc biệt"),
                    email: Yup.string()
                        .required('Email không được để trống')
                        .max(50, "Email không được lớn hơn 50")
                        .matches(/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/, 'Email không hợp lệ'),
                    phone: Yup.string()
                        .required('Số điện thoại không được để trống')
                        .min(10, "Số điện thoại phải tối thiểu 10 chữ số")
                        .matches(/^[0-9]+$/, 'Số điện thoại không hợp lệ'),
                    dateOfBirth: Yup.string()
                        .required("Ngày tháng năm không được để trống")
                        .matches(/^\d{4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$/, "Ngày tháng năm  không hợp lệ"),
                    address: Yup.string()
                        .required("Địa chỉ không được để trống")
                        .min(5, 'Địa chỉ không được bé hơn 5')
                        .max(50, 'Địa chỉ viên không được lớn hơn 50'),
                    grade:Yup.string()
                        .required("Lớp không được để trống")


                })}
            >
                <Form>
                    <div className="container">

                        <div className="header">
                            <h2 className="title">THÊM MỚI SINH VIÊN</h2>
                        </div>


                            <div className="row">

                                <div className="col-md-3 mr-2">
                                    <div className="avatar-container">
                                        <img src={anh} alt="avatar" className="avatar"
                                             id="avatar-image"/>
                                        <div className="form-group mt-2" style={{textAlign: "center"}}>
                                            <label>Chọn ảnh đại diện</label>
                                            <input type="file"
                                                   className="form-control form-control-file inputfile btn btn-primary"
                                                   id="avatar" onChange={(e) => displayImage(e.target)} name="avatar"/>
                                            <br/>
                                            <label htmlFor="avatar">Chọn tệp</label>
                                            <ErrorMessage name="avatar" className="text-danger" component="p"/>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-md-4 mr-5">
                                    <div className="form-group">
                                        <label htmlFor="name">Tên sinh viên (<span
                                            className="text-danger">*</span>):</label>
                                        <Field type="text" className="form-control" id="name" name="name"/>
                                        <ErrorMessage name="name" className="text-danger" component="p"/>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="dateOfBirth">Ngày Sinh (<span className="text-danger">*</span>):</label>
                                        <Field type="text" className="form-control" id="dateOfBirth"
                                               name="dateOfBirth"/>
                                        <ErrorMessage name="dateOfBirth" className="text-danger" component="p"/>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="grade">Lớp (<span className="text-danger">*</span>):</label>
                                        <Field as="select" className="form-control" id="grade" name="grade">
                                            {grades && grades.length > 0 ? (
                                                grades.map((grade) => (
                                                    <option key={grade.gradeId} value={grade.gradeId}>{grade.name}</option>
                                                ))
                                            ) : (
                                                <option value="" disabled>Không có lớp nào</option>
                                            )}
                                        </Field>
                                        <ErrorMessage name="grade" className="text-danger" component="p"/>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="email">Email (<span className="text-danger">*</span>):</label>
                                        <Field type="text" className="form-control" id="email" name="email"/>
                                        <ErrorMessage name="email" className="text-danger" component="p"/>
                                    </div>
                                </div>
                                <div className="col-md-4">
                                    <div className="form-group">
                                        <label htmlFor="phone">Số Điện Thoại (<span
                                            className="text-danger">*</span>):</label>
                                        <Field type="text" className="form-control" id="phone" name="phone"/>
                                        <ErrorMessage name="phone" className="text-danger" component="p"/>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="address">Địa Chỉ (<span
                                            className="text-danger">*</span>):</label>
                                        <Field as="textarea" className="form-control" id="address" name="address"/>
                                        <ErrorMessage name="address" className="text-danger" component="p"/>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="gender">Giới Tính (<span
                                            className="text-danger">*</span>):</label>
                                        <Field as="select" className="form-control" id="gender" name="gender">
                                            <option value="true">Nam</option>
                                            <option value="false">Nữ</option>
                                        </Field>
                                    </div>
                                    <div className="mt-3 save-exit-buttons">
                                        <button type="submit" className="btn btn-outline-success">Lưu</button>
                                        <button className="btn btn-outline-secondary ml-2">Thoát</button>
                                    </div>
                                </div>
                            </div>
                    </div>
                </Form>
            </Formik>
        </>
    );
}